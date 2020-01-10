package ro.msg.learning.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Domain.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer> {
}
