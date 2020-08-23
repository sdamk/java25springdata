package pl.sda.spring.data.springData.service;

import org.springframework.stereotype.Service;
import pl.sda.spring.data.springData.entity.Employee;
import pl.sda.spring.data.springData.entity.Order;
import pl.sda.spring.data.springData.repository.EmployeeRepository;
import pl.sda.spring.data.springData.repository.OrderRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OrderRepository orderRepository;

    //@Autowired
    public EmployeeService(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        this.employeeRepository = employeeRepository;
        this.orderRepository = orderRepository;
    }

    public long createEmployeeWithManyOrders() {
        System.out.println("Creating employee with many orders");
        Employee employee = new Employee("New Michal", "Kot 1", 30);

        Order order1 = new Order(employee);
        Order order2 = new Order(employee);
        Order order3 = new Order(employee);
        Order order4 = new Order(employee);
        Order order5 = new Order(employee);
        Order order6 = new Order(employee);

        employeeRepository.save(employee);
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        orderRepository.save(order4);
        orderRepository.save(order5);
        orderRepository.save(order6);
        return employee.getId();
    }

    public void printEmployees() {
        System.out.println("Printing employees");
        List<Employee> all = employeeRepository.findAllFetchType();
        System.out.println("----");
        all.forEach(employee -> {
            List<Order> orders = employee.getOrders();
            System.out.println(orders);
            System.out.println("-------");
        });
    }

    public void createEmployeeWithOneOrder() {
        System.out.println("Creating a new Employee with one order");
        Employee employee = new Employee("Michal", "Test", 30);
        Order order = new Order();

        order.setEmployee(employee);

        employeeRepository.save(employee);
        orderRepository.save(order);
    }

    //fixme
    public long addEmployee(Employee employee) {
        System.out.println("Adding new employee");
        Employee addedEmployee = employeeRepository.save(employee);
        return addedEmployee.getId();
    }

    public void changeEmployeeFirstName(long idEmployee, String firstName) {
        System.out.println("Changing employee name");
        Employee employee = employeeRepository
                .findById(idEmployee)
                .orElseThrow(() -> new RuntimeException("Not found"));

        employee.setFirstName(firstName);
        System.out.println("TEST");
    }
}
