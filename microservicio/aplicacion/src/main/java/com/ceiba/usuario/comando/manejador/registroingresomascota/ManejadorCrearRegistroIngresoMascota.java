package com.ceiba.usuario.comando.manejador.registroingresomascota;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoRegistroIngresoMascota;
import com.ceiba.usuario.comando.fabrica.FabricaRegistroIngresoMascota;
import com.ceiba.usuario.modelo.entidad.RegistroIngresoMascota;
import com.ceiba.usuario.servicio.registroingresomascota.ServicioCrearRegistroIngresoMascota;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearRegistroIngresoMascota implements ManejadorComandoRespuesta<ComandoRegistroIngresoMascota, ComandoRespuesta<Long>> {

    private final FabricaRegistroIngresoMascota fabricaRegistroIngresoMascota;
    private final ServicioCrearRegistroIngresoMascota servicioCrearRegistroIngresoMascota;

    public ManejadorCrearRegistroIngresoMascota(FabricaRegistroIngresoMascota fabricaRegistroIngresoMascota, ServicioCrearRegistroIngresoMascota servicioCrearRegistroIngresoMascota) {
        this.fabricaRegistroIngresoMascota = fabricaRegistroIngresoMascota;
        this.servicioCrearRegistroIngresoMascota = servicioCrearRegistroIngresoMascota;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoRegistroIngresoMascota comandoRegistroIngresoMascota) {
        RegistroIngresoMascota registroIngresoMascota = fabricaRegistroIngresoMascota.crear(comandoRegistroIngresoMascota);
        return new ComandoRespuesta<>(servicioCrearRegistroIngresoMascota.ejecutar(registroIngresoMascota));
    }
}
