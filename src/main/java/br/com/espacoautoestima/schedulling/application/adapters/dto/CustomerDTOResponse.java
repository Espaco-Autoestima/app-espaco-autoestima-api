package br.com.espacoautoestima.schedulling.application.adapters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTOResponse {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String cpf;
}
