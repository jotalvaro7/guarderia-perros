package com.ceiba.usuario.servicio.registroingresomascota;

import com.ceiba.usuario.puerto.repositorio.RepositorioRegistroIngresoMascota;

public class ServicioEliminarRegistroIngresoMascota {

    private final RepositorioRegistroIngresoMascota repositorioRegistroIngresoMascota;

    public ServicioEliminarRegistroIngresoMascota(RepositorioRegistroIngresoMascota repositorioRegistroIngresoMascota) {
        this.repositorioRegistroIngresoMascota = repositorioRegistroIngresoMascota;
    }

    public void ejecutar(Long idMascota){
        repositorioRegistroIngresoMascota.eliminar(idMascota);
    }

}
