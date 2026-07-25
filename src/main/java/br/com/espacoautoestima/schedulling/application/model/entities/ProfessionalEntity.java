package br.com.espacoautoestima.schedulling.application.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "professionals")
public class ProfessionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professionals_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "phoneNumber", length = 25, nullable = false)
    private String phoneNumber;

    @Column(name = "email", length = 40)
    private String email;

    @Column(name = "speciality", length = 20, nullable = false)
    private String speciality;
}
