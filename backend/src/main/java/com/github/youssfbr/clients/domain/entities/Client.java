package com.github.youssfbr.clients.domain.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(length = 60)
    private String email;

    @Column(length = 11)
    private String cpf;

    private LocalDate birthDate;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateRegister;

    @PrePersist
    public void prePersist() {
        setDateRegister(OffsetDateTime.now());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
