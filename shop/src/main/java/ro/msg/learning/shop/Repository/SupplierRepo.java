package ro.msg.learning.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Domain.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {
}
