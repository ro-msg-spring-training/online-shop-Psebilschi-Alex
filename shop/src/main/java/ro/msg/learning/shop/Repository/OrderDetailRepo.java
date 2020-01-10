package ro.msg.learning.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Domain.OrderDetail;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Integer> {
}
