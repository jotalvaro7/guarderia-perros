package com.ceiba.mascota.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoMascota;

import java.time.LocalDateTime;

public class ComandoMascotaTestDataBuilder {

    private Long id;
    private String nombre;
    private String raza;
    private String peso;
    private LocalDateTime fechaIngreso;
    private Long idUsuario;

    public ComandoMascotaTestDataBuilder(){
        nombre = "Luna";
        raza = "Golden Retriver";
        peso = "15Kg";
        fechaIngreso = LocalDateTime.now();
        idUsuario = 1L;
    }

    public ComandoMascota build(){
        return new ComandoMascota(id, nombre, raza, peso, fechaIngreso, idUsuario);
    }

}

