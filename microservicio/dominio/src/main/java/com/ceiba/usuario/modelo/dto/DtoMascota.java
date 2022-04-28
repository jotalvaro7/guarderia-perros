package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoMascota {

    private Long id;
    private String nombre;
    private String raza;
    private String peso;
    private Long idUsuario;

}
