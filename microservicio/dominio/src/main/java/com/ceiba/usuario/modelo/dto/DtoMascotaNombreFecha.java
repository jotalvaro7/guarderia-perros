package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoMascotaNombreFecha {

    private String nombre;
    private LocalDateTime fechaIngreso;

}
