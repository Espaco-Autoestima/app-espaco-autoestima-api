package br.com.espacoautoestima.schedulling.application.model.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customers_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "email", length = 40)
    private String email;

    @Column(name = "phoneNumber", length = 25, nullable = false)
    private String phoneNumber;

    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
}
