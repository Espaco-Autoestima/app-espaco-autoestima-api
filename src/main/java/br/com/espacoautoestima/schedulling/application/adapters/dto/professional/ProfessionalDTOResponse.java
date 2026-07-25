package br.com.espacoautoestima.schedulling.application.adapters.dto.professional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalDTOResponse {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String speciality;
}
