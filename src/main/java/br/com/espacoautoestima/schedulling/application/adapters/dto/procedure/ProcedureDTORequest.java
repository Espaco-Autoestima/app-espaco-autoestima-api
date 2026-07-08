package br.com.espacoautoestima.schedulling.application.adapters.dto.procedure;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class ProcedureDTORequest {

    @JsonIgnore
    private Long id;

    @JsonProperty("name")
    @NotBlank(message = "Field name is required")
    private String name;

    @JsonProperty("description")
    @NotBlank(message = "Field description is required")
    private String description;
}
