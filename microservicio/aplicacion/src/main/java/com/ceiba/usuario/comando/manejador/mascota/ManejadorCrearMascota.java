package com.ceiba.usuario.comando.manejador.mascota;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoMascota;
import com.ceiba.usuario.comando.fabrica.FabricaMascota;
import com.ceiba.usuario.modelo.entidad.Mascota;
import com.ceiba.usuario.servicio.mascota.ServicioCrearMascota;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearMascota implements ManejadorComandoRespuesta<ComandoMascota, ComandoRespuesta<Long>> {

    private final FabricaMascota fabricaMascota;
    private final ServicioCrearMascota servicioCrearMascota;

    public ManejadorCrearMascota(FabricaMascota fabricaMascota, ServicioCrearMascota servicioCrearMascota) {
        this.fabricaMascota = fabricaMascota;
        this.servicioCrearMascota = servicioCrearMascota;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoMascota comandoMascota) {
        Mascota mascota = this.fabricaMascota.crear(comandoMascota);
        return new ComandoRespuesta<>(servicioCrearMascota.ejecutar(mascota));
    }
}
