package br.com.espacoautoestima.schedulling.application.adapters.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureDTORequest {
    private Long id;

    @NotBlank(message = "Field name is required")
    private String name;

    @NotBlank(message = "Field description is required")
    private String description;
}
