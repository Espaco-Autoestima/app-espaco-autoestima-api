package br.com.espacoautoestima.schedulling.application.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String companyName;
}
