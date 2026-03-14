package br.com.espacoautoestima.schedulling.application.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String name;
    private String phoneNumber;
    private String email;
    private String cpf;
}
