package com.ceiba.usuario.servicio.mascota;

import com.ceiba.usuario.modelo.entidad.Mascota;
import com.ceiba.usuario.puerto.repositorio.RepositorioMascota;

public class ServicioCrearMascota {

    private final RepositorioMascota repositorioMascota;

    public ServicioCrearMascota(RepositorioMascota repositorioMascota) {
        this.repositorioMascota = repositorioMascota;
    }


    public Long ejecutar(Mascota mascota){
        return this.repositorioMascota.crear(mascota);
    }

}
