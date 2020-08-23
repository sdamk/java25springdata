package pl.sda.spring.data.springData.service;

import org.springframework.stereotype.Service;
import pl.sda.spring.data.springData.entity.Order;
import pl.sda.spring.data.springData.entity.Product;
import pl.sda.spring.data.springData.repository.OrderRepository;
import pl.sda.spring.data.springData.repository.ProductRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public void createOrderWithManyProducts() {
        Product product1 = new Product("P1");
        productRepository.save(product1);
        Product product2 = new Product("P2");
        productRepository.save(product2);
        Product product3 = new Product("P3");
        productRepository.save(product3);
        Product product4 = new Product("P4");
        productRepository.save(product4);
        Product product5 = new Product("P5");
        productRepository.save(product5);


        Order order = new Order();
        order.getProducts().add(product1);
        order.getProducts().add(product1);
        order.getProducts().add(product1);
        order.getProducts().add(product1);
        order.getProducts().add(product1);
        order.getProducts().add(product1);
        order.getProducts().add(product1);
        order.getProducts().add(product1);
        order.getProducts().add(product2);
        order.getProducts().add(product3);
        order.getProducts().add(product4);
        order.getProducts().add(product5);
        orderRepository.save(order);
    }

    public void removeProducts() {
        Order order = orderRepository.findById(1L).get();
        Product product = productRepository.findById(1L).get();

        order.getProducts().remove(product);
    }
}
