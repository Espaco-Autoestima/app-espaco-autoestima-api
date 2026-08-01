package br.com.espacoautoestima.schedulling.application.adapters.dto.supplier;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTORequest {

    private Long id;

    @JsonProperty("name")
    @NotBlank(message = "Field name is required")
    private String name;

    @JsonProperty("email")
    @NotBlank(message = "Field email is required")
    private String email;

    @JsonProperty("phoneNumber")
    @NotBlank(message = "Field phoneNumber is required")
    private String phoneNumber;

    @JsonProperty("companyName")
    @NotBlank(message = "Field companyName is required")
    private String companyName;
}
