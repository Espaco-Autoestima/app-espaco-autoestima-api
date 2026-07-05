package br.com.espacoautoestima.schedulling.application.adapters.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTORequest {

    @JsonIgnore
    private Long id;

    @JsonProperty("name")
    @NotBlank(message = "Field name is required")
    private String name;

    @JsonProperty("email")
    @NotBlank(message = "Field email is required")
    @Email(message = "Field email must be a valid email address")
    private String email;

    @JsonProperty("phone_number")
    @NotBlank(message = "Field phoneNumber is required")
    private String phoneNumber;

    @JsonProperty("cpf")
    @NotBlank(message = "Field CPF is required")
    private String cpf;
}
