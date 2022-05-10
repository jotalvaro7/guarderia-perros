package com.ceiba.usuario.comando.fabrica;


import com.ceiba.usuario.modelo.dto.DtoMascotaNombreFecha;
import com.ceiba.usuario.modelo.entidad.FacturaMascota;
import com.ceiba.usuario.puerto.dao.DaoMascota;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaFacturaMascota {

    private final DaoMascota daoMascota;

    public FabricaFacturaMascota(DaoMascota daoMascota) {
        this.daoMascota = daoMascota;
    }

    public FacturaMascota crear(Long id) {
        DtoMascotaNombreFecha dtoMascotaNombreFecha = daoMascota.obtenerNombreFechaIngresoMascota(id);
        return new FacturaMascota(
                dtoMascotaNombreFecha.getNombre(),
                dtoMascotaNombreFecha.getFechaIngreso(),
                LocalDateTime.now(),
                "",
                0L
        );
    }
}
