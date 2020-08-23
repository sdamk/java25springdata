package pl.sda.spring.data.springData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.spring.data.springData.entity.Employee;
import pl.sda.spring.data.springData.service.EmployeeService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private final EmployeeService service;

    public SpringDataApplication(EmployeeService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.createEmployeeWithManyOrders();
        service.createEmployeeWithManyOrders();
        service.createEmployeeWithManyOrders();
        service.createEmployeeWithManyOrders();
        service.printEmployees();
    }
}
