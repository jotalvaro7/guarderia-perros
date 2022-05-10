package com.ceiba.usuario.consulta.facturamascota;

import com.ceiba.usuario.comando.fabrica.FabricaFacturaMascota;
import com.ceiba.usuario.modelo.dto.DtoMascotaNombreFecha;
import com.ceiba.usuario.modelo.entidad.FacturaMascota;
import com.ceiba.usuario.servicio.facturamascota.ServicioCobrarTiempoMascota;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCobrarTiempoMascota {

    private final FabricaFacturaMascota fabricaFacturaMascota;
    private final ServicioCobrarTiempoMascota servicioCobrarTiempoMascota;


    public ManejadorCobrarTiempoMascota(FabricaFacturaMascota fabricaFacturaMascota, ServicioCobrarTiempoMascota servicioCobrarTiempoMascota) {
        this.fabricaFacturaMascota = fabricaFacturaMascota;
        this.servicioCobrarTiempoMascota = servicioCobrarTiempoMascota;
    }


    public FacturaMascota ejecutar(Long id){
        FacturaMascota facturaMascota = fabricaFacturaMascota.crear(id);
        return servicioCobrarTiempoMascota.ejecutar(facturaMascota);
    }
}
