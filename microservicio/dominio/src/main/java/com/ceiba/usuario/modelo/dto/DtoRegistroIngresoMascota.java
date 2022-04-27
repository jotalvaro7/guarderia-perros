package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoRegistroIngresoMascota {

    private Long id;
    private Long idMascota;
    private LocalDateTime fechaIngreso;

}
