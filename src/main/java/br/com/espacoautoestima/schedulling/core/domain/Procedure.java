package br.com.espacoautoestima.schedulling.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Procedure {
    private Long id;
    private String name;
    private String description;
}
