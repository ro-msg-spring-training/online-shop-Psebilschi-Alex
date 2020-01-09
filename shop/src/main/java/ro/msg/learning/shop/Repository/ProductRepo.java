package ro.msg.learning.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Domain.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
