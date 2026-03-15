package br.com.espacoautoestima.schedulling.application.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Data
@Entity
@Table(name = "disponibility")
public class DisponibilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disponibility_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "dayDisponibility")
    private String dayOfWeek;

    @Column(name = "hourStart")
    private Time hourStart;

    @Column(name = "hourEnd")
    private Time hourEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professionals_id", nullable = false)
    private ProfessionalEntity professional;
}
