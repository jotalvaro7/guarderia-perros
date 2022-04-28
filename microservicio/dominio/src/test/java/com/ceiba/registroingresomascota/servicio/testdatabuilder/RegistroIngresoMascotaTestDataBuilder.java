package com.ceiba.registroingresomascota.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.RegistroIngresoMascota;

import java.time.LocalDateTime;

public class RegistroIngresoMascotaTestDataBuilder {

    private Long id;
    private Long idMascota;
    private LocalDateTime fechaIngreso;

    public RegistroIngresoMascotaTestDataBuilder(){
        id = 1L;
        idMascota = 1L;
        fechaIngreso = LocalDateTime.of(2022, 04, 27, 18, 00,00);;
    }

    public RegistroIngresoMascotaTestDataBuilder conIdMascota(Long idMascota){
        this.idMascota = idMascota;
        return this;
    }

    public RegistroIngresoMascotaTestDataBuilder conFechaIngreso(LocalDateTime fechaIngreso){
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public RegistroIngresoMascota build(){
        return new RegistroIngresoMascota(
                id,
                idMascota
        );
    }
}
