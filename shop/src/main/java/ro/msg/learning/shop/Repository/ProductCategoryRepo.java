package ro.msg.learning.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Domain.ProductCategory;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer> {
}
