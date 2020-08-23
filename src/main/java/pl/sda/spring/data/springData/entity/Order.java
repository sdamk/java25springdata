package pl.sda.spring.data.springData.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "ORDER_")
@NoArgsConstructor
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime dateTime = LocalDateTime.now();

    @ManyToOne
    @Setter
    private Employee employee;

    public Order(Employee employee) {
        this.employee = employee;
    }

    //FIX ME
    @ManyToMany
    private Set<Product> products = new HashSet<>();

}
