package pl.sda.spring.data.springData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import pl.sda.spring.data.springData.entity.Employee;
import pl.sda.spring.data.springData.repository.EmployeeRepository;

import java.util.List;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private final EmployeeRepository repository;

    public SpringDataApplication(EmployeeRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Employee("Michal", "Kot", 27));
        repository.save(new Employee("Jan", "Nowak", 50));
        repository.save(new Employee("Jan", "Kowalski", 50));
        repository.save(new Employee("Jan", "Kowalski", 40));
        repository.save(new Employee("Agata", "Lipska", 30));
        repository.save(new Employee("Agnieszka", "Dworak", 35));
        repository.save(new Employee("Filip", "Jakistam", 27));
        repository.save(new Employee("Andrzej", "Costam", 27));

        List<Employee> jan = repository.findByFirstName("Jan");

        /*List<Employee> list = repository
                .findAll(Sort.by("firstName").and(Sort.by(Sort.Direction.ASC, "age")));
*/

        List<Employee> list = repository.testSortBySth();
        list.forEach(System.out::println);
        System.out.println("==============");

        Page<Employee> all = repository.findAll(PageRequest.of(2, 3));

        all.forEach(System.out::println);

    }
}
