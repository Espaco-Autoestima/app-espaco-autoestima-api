package br.com.espacoautoestima.schedulling.application.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private String id;
    private String clientName;
    private Integer sessionQuantity;
    private String professionalName;
    private Date dateSchedule;
    private Date hourSchedule;
}
