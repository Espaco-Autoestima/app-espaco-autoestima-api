package br.com.espacoautoestima.schedulling.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professional {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String speciality;
}
