package ro.msg.learning.shop.Service;


import org.springframework.data.util.Pair;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.Domain.OrderDetail;
import ro.msg.learning.shop.Domain.Orders;
import ro.msg.learning.shop.Domain.Product;
import ro.msg.learning.shop.Domain.Stock;
import ro.msg.learning.shop.Exceptions.OrderNotAvailableException;
import ro.msg.learning.shop.Exceptions.OrderStrategyException;
import ro.msg.learning.shop.Exceptions.ProductCategoryNotFoundException;
import ro.msg.learning.shop.Exceptions.ProductNotFoundException;
import ro.msg.learning.shop.Repository.*;
import ro.msg.learning.shop.Service.orderStrategy.DetermineOrder;
import ro.msg.learning.shop.Service.orderStrategy.OrderStrategy;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;
    private final OrderDetailRepo orderDetailRepo;
    private final LocationRepo locationRepo;
    private final ProductRepo productRepo;
    private final StockRepo stockRepo;

    public OrderDTO createOrder(OrderDTO newOrder) {

        OrderStrategy singleLocation = OrderStrategy.singleLocation(productRepo, stockRepo, orderRepo, orderDetailRepo, locationRepo);
        OrderStrategy mostAbundant = OrderStrategy.mostAbundant(productRepo, stockRepo, orderRepo, orderDetailRepo, locationRepo);

        DetermineOrder determineOrder = new DetermineOrder(singleLocation);

        try {
            return determineOrder.createOrder(newOrder);
        } catch (OrderStrategyException ex1) {
            determineOrder.setStrategy(mostAbundant);
            try {
                return determineOrder.createOrder(newOrder);
            } catch (OrderStrategyException ex2) {
                throw new OrderNotAvailableException();
            }
        }
    }
}
