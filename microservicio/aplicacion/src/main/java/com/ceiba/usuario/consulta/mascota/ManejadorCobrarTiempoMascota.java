package com.ceiba.usuario.consulta.mascota;

import com.ceiba.usuario.modelo.entidad.FacturaMascota;
import com.ceiba.usuario.servicio.mascota.ServicioCobrarTiempoMascota;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCobrarTiempoMascota {

    private final ServicioCobrarTiempoMascota servicioCobrarTiempoMascota;

    public ManejadorCobrarTiempoMascota(ServicioCobrarTiempoMascota servicioCobrarTiempoMascota) {
        this.servicioCobrarTiempoMascota = servicioCobrarTiempoMascota;
    }


    public FacturaMascota ejecutar(Long id){
        return servicioCobrarTiempoMascota.ejecutar(id);
    }
}
