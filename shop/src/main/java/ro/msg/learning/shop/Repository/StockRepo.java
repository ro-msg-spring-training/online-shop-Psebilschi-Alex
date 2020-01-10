package ro.msg.learning.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Domain.Location;
import ro.msg.learning.shop.Domain.Product;
import ro.msg.learning.shop.Domain.Stock;

import java.util.List;

public interface StockRepo extends JpaRepository<Stock, Integer> {
    List<Stock> findByProductAndQuantityGreaterThanEqual(Product product, Integer quantity);

    List<Stock> findByProductAndLocationAndQuantityGreaterThanEqual(Product product, Location location, Integer quantity);

    List<Stock> findTopByProductAndQuantityGreaterThanEqualOrderByQuantityDesc(Product product, Integer quantity);
}
