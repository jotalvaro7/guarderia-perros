package com.ceiba.registroingresomascota.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoRegistroIngresoMascota;

import java.time.LocalDateTime;

public class ComandoRegistroIngresoMascotaTestDataBuilder {

    private Long id;
    private Long idUsuario;
    private LocalDateTime fechaIngreso;

    public ComandoRegistroIngresoMascotaTestDataBuilder(){
        idUsuario = 1L;
        fechaIngreso = LocalDateTime.now();
    }

    public ComandoRegistroIngresoMascota build(){
        return new ComandoRegistroIngresoMascota(id, idUsuario, fechaIngreso);
    }
}
