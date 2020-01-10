package ro.msg.learning.shop.Service.orderStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.Domain.*;
import ro.msg.learning.shop.Exceptions.OrderNotAvailableException;
import ro.msg.learning.shop.Exceptions.OrderStrategyException;
import ro.msg.learning.shop.Exceptions.ProductNotFoundException;
import ro.msg.learning.shop.Repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface OrderStrategy {

    OrderDTO useStrategy(OrderDTO newOrder);

    static OrderStrategy singleLocation(ProductRepo productRepo, StockRepo stockRepo, OrderRepo orderRepo, OrderDetailRepo orderDetailRepo, LocationRepo locationRepo) {

        return newOrder -> {
            Map<Integer, Integer> orderList = newOrder.getProductsList();
            // in availableLocation we will store all the locations that have all the products (from a certain moment) in stock
            List<Location> availableLocation = locationRepo.findAll();

            //Check if we have all the products in stock
            for (Map.Entry<Integer, Integer> pair : orderList.entrySet()) {
                // in currentLocations we will store all the location where the current product is available.
                // the duplicate values from "availableLocation" and "currentLocations" means all the products (until now) are available in that location
                List<Location> currentLocations = new ArrayList<>();
                Product prod = productRepo.findById(pair.getKey())
                        .orElseThrow(() -> new ProductNotFoundException(pair.getKey()));

                List<Stock> stockList = stockRepo.findByProductAndQuantityGreaterThanEqual(prod, pair.getValue());

                if (stockList.isEmpty()) {
                    throw new OrderNotAvailableException();
                }

                for (Stock stock : stockList) {
                    Location location = locationRepo.findById(stock.getLocation().getId()).get();
                    if (availableLocation.contains(location)) {
                        currentLocations.add(location);
                    }
                }

                if (currentLocations.isEmpty()) {
                    throw new OrderStrategyException();
                }

                availableLocation = new ArrayList<>(currentLocations);
            }

            // if we are here, at least one location have all the products in stock
            Location loc = availableLocation.get(0);
            Orders orders = Orders.builder()
                    .city(newOrder.getDeliveryCity())
                    .country(newOrder.getDeliveryCountry())
                    .create_at(newOrder.getTimestamp())
                    .street_address(newOrder.getDeliveryStreet())
                    .shipped_from(loc)
                    .build();
            orderRepo.save(orders);

            for (Map.Entry<Integer, Integer> pair : orderList.entrySet()) {

                Product prod = productRepo.findById(pair.getKey()).get();
                List<Stock> stockList = stockRepo.findByProductAndLocationAndQuantityGreaterThanEqual(prod, loc, pair.getValue());

                //for first entry, we calculate the remaining stock
                Stock stock = stockList.get(0);
                stock.setQuantity(stock.getQuantity() - pair.getValue());
                stockRepo.save(stock);

                //create the order detail
                orderDetailRepo.save(OrderDetail.builder()
                        .quantity(pair.getValue())
                        .product(prod)
                        .orders(orders)
                        .build());
            }
            return newOrder;
        };
    }

    static OrderStrategy mostAbundant(ProductRepo productRepo, StockRepo stockRepo, OrderRepo orderRepo, OrderDetailRepo orderDetailRepo, LocationRepo locationRepo) {
        return newOrder -> {
            Map<Integer, Integer> orderList = newOrder.getProductsList();
            Orders orders = Orders.builder()
                    .city(newOrder.getDeliveryCity())
                    .country(newOrder.getDeliveryCountry())
                    .create_at(newOrder.getTimestamp())
                    .street_address(newOrder.getDeliveryStreet())
                    .build();
            orderRepo.save(orders);

            for (Map.Entry<Integer, Integer> pair : orderList.entrySet()) {
                Product prod = productRepo.findById(pair.getKey()).get();
                List<Stock> stockList = stockRepo.findTopByProductAndQuantityGreaterThanEqualOrderByQuantityDesc(prod, pair.getValue());

                Stock stock = stockList.get(0);
                stock.setQuantity(stock.getQuantity() - pair.getValue());
                stockRepo.save(stock);

                //create the order detail
                orderDetailRepo.save(OrderDetail.builder()
                        .quantity(pair.getValue())
                        .product(prod)
                        .orders(orders)
                        .build());
            }

            return newOrder;
        };
    }
}
