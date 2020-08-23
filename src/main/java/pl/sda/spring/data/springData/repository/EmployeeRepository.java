package pl.sda.spring.data.springData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.sda.spring.data.springData.entity.Employee;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstName(String firstName);

    @Query("from Employee e ORDER BY e.firstName, e.age asc ")
    List<Employee> testSortBySth();
}
