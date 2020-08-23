package pl.sda.spring.data.springData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.spring.data.springData.service.EmployeeService;
import pl.sda.spring.data.springData.service.OrderService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private final EmployeeService service;
    private final OrderService orderService;

    public SpringDataApplication(EmployeeService service,
                                 OrderService orderService) {
        this.service = service;
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        orderService.createOrderWithManyProducts();
        System.out.println("--------------------------------------");
        orderService.removeProducts();
    }
}
