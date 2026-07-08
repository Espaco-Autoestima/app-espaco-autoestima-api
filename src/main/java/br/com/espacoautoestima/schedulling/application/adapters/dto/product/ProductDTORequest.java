package br.com.espacoautoestima.schedulling.application.adapters.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTORequest {

    @JsonIgnore
    private Long id;

    @JsonProperty("name")
    @NotBlank(message = "Field name is required")
    private String name;

    @JsonProperty("description")
    @NotBlank(message = "Field description is required")
    private String description;

    @JsonProperty("expiration_date")
    @NotBlank(message = "Field expirationDate is required")
    private Date expirationDate;

    @JsonProperty("quantity")
    @NotBlank(message = "Field quantity is required")
    private Integer quantity;

    @JsonProperty("brand")
    @NotBlank(message = "Field brand is required")
    private String brand;

    @JsonProperty("price")
    @NotBlank(message = "Field price is required")
    private Double price;
}
