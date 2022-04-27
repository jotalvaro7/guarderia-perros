package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class RegistroIngresoMascota {

    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_MASCOTA = "Se debe ingresar el Id de la mascota";
    private Long idMascota;
    private LocalDateTime fechaIngreso;

    public RegistroIngresoMascota(Long idMascota) {

        validarObligatorio(idMascota, SE_DEBE_INGRESAR_EL_ID_DE_LA_MASCOTA);

        this.idMascota = idMascota;
        this.fechaIngreso = LocalDateTime.now();
    }
}
