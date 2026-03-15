package br.com.espacoautoestima.schedulling.application.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "suppliers")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suppliers_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "email", length = 40)
    private String email;

    @Column(name = "phoneNumber", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "companyName", length = 20, nullable = false)
    private String companyName;
}
