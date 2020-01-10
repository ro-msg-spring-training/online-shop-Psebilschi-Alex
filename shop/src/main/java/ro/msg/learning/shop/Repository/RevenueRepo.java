package ro.msg.learning.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Domain.Revenue;

public interface RevenueRepo extends JpaRepository<Revenue, Integer> {
}
