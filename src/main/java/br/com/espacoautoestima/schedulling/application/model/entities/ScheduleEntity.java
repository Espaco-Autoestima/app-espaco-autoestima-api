package br.com.espacoautoestima.schedulling.application.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "schedules")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "customerName", length = 45, nullable = false)
    private String customerName;

    @Column(name = "professionalName", length = 45, nullable = false)
    private String professionalName;

    @Column(name = "sessionQuantity")
    private Integer sessionQuantity;

    @Column(name = "dateSchedule")
    private Date dateSchedule;

    @Column(name = "hourSchedule")
    private Date hourSchedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customers_id", nullable = false)
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professionals_id", nullable = false)
    private ProfessionalEntity professional;
}
