package ro.msg.learning.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Domain.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
