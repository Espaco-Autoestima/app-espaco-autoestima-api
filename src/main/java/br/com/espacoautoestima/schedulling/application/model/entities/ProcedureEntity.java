package br.com.espacoautoestima.schedulling.application.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "procedures")
public class ProcedureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procedures_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "description", length = 100, nullable = false)
    private String description;
}
