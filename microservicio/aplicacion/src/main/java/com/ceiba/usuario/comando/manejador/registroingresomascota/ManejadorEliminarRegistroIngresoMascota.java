package com.ceiba.usuario.comando.manejador.registroingresomascota;

import com.ceiba.usuario.servicio.registroingresomascota.ServicioEliminarRegistroIngresoMascota;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarRegistroIngresoMascota {

    private final ServicioEliminarRegistroIngresoMascota servicioEliminarRegistroIngresoMascota;

    public ManejadorEliminarRegistroIngresoMascota(ServicioEliminarRegistroIngresoMascota servicioEliminarRegistroIngresoMascota) {
        this.servicioEliminarRegistroIngresoMascota = servicioEliminarRegistroIngresoMascota;
    }

    public void ejecutar(Long idMascota){
        this.servicioEliminarRegistroIngresoMascota.ejecutar(idMascota);
    }
}
