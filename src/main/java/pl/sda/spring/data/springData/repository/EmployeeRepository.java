package pl.sda.spring.data.springData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.spring.data.springData.entity.Employee;

import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstName(String firstName);

    @Query("from Employee e ORDER BY e.firstName, e.age asc ")
    List<Employee> testSortBySth();

    @Query("from Employee e LEFT JOIN FETCH e.orders ")
    List<Employee> findAllFetchType();
}
