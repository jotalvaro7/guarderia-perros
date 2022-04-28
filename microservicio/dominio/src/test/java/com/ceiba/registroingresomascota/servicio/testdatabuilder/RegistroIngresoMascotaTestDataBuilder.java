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
        fechaIngreso = LocalDateTime.now();
    }

    public RegistroIngresoMascotaTestDataBuilder conIdMascota(Long idMascota){
        this.idMascota = idMascota;
        return this;
    }

    public RegistroIngresoMascota build(){
        return new RegistroIngresoMascota(
                id,
                idMascota
        );
    }
}
