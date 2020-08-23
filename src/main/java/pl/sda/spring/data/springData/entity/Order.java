package pl.sda.spring.data.springData.entity;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "ORDER_")
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                '}';
    }
}
