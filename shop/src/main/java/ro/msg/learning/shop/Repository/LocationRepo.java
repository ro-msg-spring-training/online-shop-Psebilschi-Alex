package ro.msg.learning.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Domain.Location;

public interface LocationRepo extends JpaRepository<Location, Integer> {
}
