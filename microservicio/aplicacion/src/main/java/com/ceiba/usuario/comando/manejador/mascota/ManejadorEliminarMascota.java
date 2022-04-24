package com.ceiba.usuario.comando.manejador.mascota;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.mascota.ServicioEliminarMascota;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarMascota implements ManejadorComando<Long> {

    private final ServicioEliminarMascota servicioEliminarMascota;

    public ManejadorEliminarMascota(ServicioEliminarMascota servicioEliminarMascota) {
        this.servicioEliminarMascota = servicioEliminarMascota;
    }

    @Override
    public void ejecutar(Long idMascota) {
        this.servicioEliminarMascota.ejecutar(idMascota);
    }
}
