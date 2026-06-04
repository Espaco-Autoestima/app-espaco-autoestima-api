package br.com.espacoautoestima.schedulling.application.adapters.dto;

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
    private Long id;

    @NotBlank(message = "Field name is required")
    private String name;

    @NotBlank(message = "Field email is required")
    @Email(message = "Field email must be a valid email address")
    private String email;

    @NotBlank(message = "Field phoneNumber is required")
    private String phoneNumber;

    @NotBlank(message = "Field CPF is required")
    private String cpf;
}
