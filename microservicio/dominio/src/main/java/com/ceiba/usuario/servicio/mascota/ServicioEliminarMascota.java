package com.ceiba.usuario.servicio.mascota;

import com.ceiba.usuario.puerto.repositorio.RepositorioMascota;

public class ServicioEliminarMascota {

    private final RepositorioMascota repositorioMascota;

    public ServicioEliminarMascota(RepositorioMascota repositorioMascota) {
        this.repositorioMascota = repositorioMascota;
    }

    public void ejecutar(Long id){
        this.repositorioMascota.eliminar(id);
    }
}
