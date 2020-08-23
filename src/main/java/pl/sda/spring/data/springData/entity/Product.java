package pl.sda.spring.data.springData.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Product(String name) {
        this.name = name;
    }

    //FIX ME
    @ManyToMany(mappedBy = "products")
    private Set<Order> orders = new HashSet<>();
}
