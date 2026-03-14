package br.com.espacoautoestima.schedulling.application.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String code;
    private String name;
    private String description;
    private Date expirationDate;
    private Integer quantity;
    private String brand;
    private Double price;
}
