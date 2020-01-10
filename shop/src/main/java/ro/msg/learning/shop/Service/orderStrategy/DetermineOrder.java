package ro.msg.learning.shop.Service.orderStrategy;

import lombok.AllArgsConstructor;
import lombok.Setter;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.Repository.ProductRepo;
import ro.msg.learning.shop.Repository.StockRepo;

@AllArgsConstructor @Setter
public class DetermineOrder {
    private OrderStrategy strategy;

    public OrderDTO createOrder(OrderDTO newOrder) {
        return this.strategy.useStrategy(newOrder);
    }
}
