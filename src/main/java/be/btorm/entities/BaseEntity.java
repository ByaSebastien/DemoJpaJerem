package be.btorm.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    private LocalDate creationDate;

    @Temporal(TemporalType.DATE)
    private LocalDate lastUpdate;
}