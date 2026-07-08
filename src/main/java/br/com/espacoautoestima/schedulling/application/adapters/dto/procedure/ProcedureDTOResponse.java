package br.com.espacoautoestima.schedulling.application.adapters.dto.procedure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureDTOResponse {
    private Long id;
    private String name;
    private String description;
}
