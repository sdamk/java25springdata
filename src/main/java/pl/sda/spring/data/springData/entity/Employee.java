package pl.sda.spring.data.springData.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private long age;

    @OneToMany(mappedBy = "employee")
    private List<Order> orders = new ArrayList<>();

    public Employee() {

    }

    public Employee(String firstName, String lastName, long age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
