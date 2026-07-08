package br.com.espacoautoestima.schedulling.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private Date expirationDate;
    private Integer quantity;
    private String brand;
    private Double price;
}
