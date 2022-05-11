package com.ceiba.mascota.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoMascota;


public class ComandoMascotaTestDataBuilder {

    private Long id;
    private String nombre;
    private String raza;
    private String peso;
    private Long idUsuario;

    public ComandoMascotaTestDataBuilder(){
        nombre = "Luna";
        raza = "Golden Retriver";
        peso = "15Kg";
        idUsuario = 1L;
    }

    public ComandoMascota build(){
        return new ComandoMascota(id, nombre, raza, peso, idUsuario);
    }

}

