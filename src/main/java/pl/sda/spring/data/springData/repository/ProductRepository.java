package pl.sda.spring.data.springData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.spring.data.springData.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
