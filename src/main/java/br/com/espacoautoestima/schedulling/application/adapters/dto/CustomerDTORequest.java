package br.com.espacoautoestima.schedulling.application.adapters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTORequest {
    private UUID id;
    private String name;
    private String email;
    private String phoneNumber;
    private String cpf;
}
