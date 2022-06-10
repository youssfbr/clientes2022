package com.github.youssfbr.clients.domain.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String note;

    @ManyToOne
    private Client client;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderService orderService = (OrderService) o;
        return id != null && Objects.equals(id, orderService.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
