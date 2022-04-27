package com.ceiba.usuario.servicio.registroingresomascota;

import com.ceiba.usuario.modelo.entidad.RegistroIngresoMascota;
import com.ceiba.usuario.puerto.repositorio.RepositorioRegistroIngresoMascota;

public class ServicioCrearRegistroIngresoMascota {

    private final RepositorioRegistroIngresoMascota repositorioRegistroIngresoMascota;

    public ServicioCrearRegistroIngresoMascota(RepositorioRegistroIngresoMascota repositorioRegistroIngresoMascota) {
        this.repositorioRegistroIngresoMascota = repositorioRegistroIngresoMascota;
    }

    public Long ejecutar(RegistroIngresoMascota registroIngresoMascota){
        return this.repositorioRegistroIngresoMascota.crear(registroIngresoMascota);
    }


}
