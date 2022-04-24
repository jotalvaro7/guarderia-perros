package com.ceiba.usuario.comando.manejador.mascota;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.comando.ComandoMascota;
import com.ceiba.usuario.comando.fabrica.FabricaMascota;
import com.ceiba.usuario.modelo.entidad.Mascota;
import com.ceiba.usuario.servicio.mascota.ServicioActualizarMascota;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarMascota implements ManejadorComando<ComandoMascota> {

    private final FabricaMascota fabricaMascota;
    private final ServicioActualizarMascota servicioActualizarMascota;

    public ManejadorActualizarMascota(FabricaMascota fabricaMascota, ServicioActualizarMascota servicioActualizarMascota) {
        this.fabricaMascota = fabricaMascota;
        this.servicioActualizarMascota = servicioActualizarMascota;
    }

    @Override
    public void ejecutar(ComandoMascota comando) {
        Mascota mascota = this.fabricaMascota.crear(comando);
        this.servicioActualizarMascota.ejecutar(mascota);
    }
}
