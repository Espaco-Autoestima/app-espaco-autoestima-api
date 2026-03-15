package br.com.espacoautoestima.schedulling.application.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "products_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "expirationDate", nullable = false, updatable = false)
    private Date expirationDate;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "brand", length = 20)
    private String brand;

    @Column(name = "price", nullable = false)
    private Double price;
}
