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
public class DeviceClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Client client;

    @OneToOne
    private Device device;

    @OneToOne
    private DeviceBrand deviceBrand;

    @Column(length = 20)
    private String model;

    @Column(length = 20)
    private String serial;

    @Column(length = 40)
    private String configuration;

    @Column(length = 20)
    private String voltage;

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
        DeviceClient deviceClient = (DeviceClient) o;
        return id != null && Objects.equals(id, deviceClient.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
