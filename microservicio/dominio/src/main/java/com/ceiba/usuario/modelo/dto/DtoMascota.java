package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoMascota {

    private Long id;
    private String nombre;
    private String raza;
    private String peso;
    private LocalDateTime fechaIngreso;
    private Long idUsuario;

}
