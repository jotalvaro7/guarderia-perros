package com.ceiba.mascota.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Mascota;

import java.time.LocalDateTime;

public class MascotaTestDataBuilder {

    private Long id;
    private String nombre;
    private String raza;
    private String peso;
    private LocalDateTime fechaIngreso;
    private Long idUsuario;

    public MascotaTestDataBuilder(){
        id = 1L;
        nombre = "Zeus";
        raza = "Doberman";
        peso = "20Kg";
        fechaIngreso = LocalDateTime.now();
        idUsuario = 2L;
    }

    public MascotaTestDataBuilder conIdUsuario(Long idUsuario){
        this.idUsuario = idUsuario;
        return this;
    }

    public MascotaTestDataBuilder conFechaIngreso(LocalDateTime fechaIngreso){
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public MascotaTestDataBuilder conPeso(String peso){
        this.peso = peso;
        return this;
    }

    public MascotaTestDataBuilder conRaza(String raza){
        this.raza = raza;
        return this;
    }

    public MascotaTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public MascotaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }



    public Mascota build(){
        return new Mascota(
                id,
                nombre,
                raza,
                peso,
                idUsuario
        );
    }
}
