package pl.sda.spring.data.springData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.data.springData.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
