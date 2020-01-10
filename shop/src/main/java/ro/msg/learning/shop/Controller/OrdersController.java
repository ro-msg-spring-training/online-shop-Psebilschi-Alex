package ro.msg.learning.shop.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.DTOs.OrderDTO;
import ro.msg.learning.shop.Service.OrderService;

@RestController
@AllArgsConstructor
public class OrdersController {
    private final OrderService orderService;

    @PostMapping("/orders")
    OrderDTO createOrder(@RequestBody OrderDTO newOrder) {
        return orderService.createOrder(newOrder);
    }
}
