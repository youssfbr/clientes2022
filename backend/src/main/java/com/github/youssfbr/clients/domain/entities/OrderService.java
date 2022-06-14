package com.github.youssfbr.clients.domain.entities;

import com.github.youssfbr.clients.domain.entities.enums.StatusOrderService;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
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
    private OffsetDateTime openDate;

    private StatusOrderService statusOrderService;

    @ManyToOne
    private DeviceClient deviceClient;

    private String claimedDefect;

    private String solutionDefect;

    private String description;

    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Column(insertable = false)
    private OffsetDateTime completionDate;

    @PrePersist
    public void prePersist() {
        setStatusOrderService(StatusOrderService.ABERTA);
        setOpenDate(OffsetDateTime.now());
    }


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
