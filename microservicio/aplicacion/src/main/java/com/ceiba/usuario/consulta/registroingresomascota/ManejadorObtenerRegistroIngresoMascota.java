package com.ceiba.usuario.consulta.registroingresomascota;

import com.ceiba.usuario.modelo.dto.DtoRegistroIngresoMascota;
import com.ceiba.usuario.puerto.dao.DaoRegistroIngresoMascota;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerRegistroIngresoMascota {

    private final DaoRegistroIngresoMascota daoRegistroIngresoMascota;

    public ManejadorObtenerRegistroIngresoMascota(DaoRegistroIngresoMascota daoRegistroIngresoMascota) {
        this.daoRegistroIngresoMascota = daoRegistroIngresoMascota;
    }

    public DtoRegistroIngresoMascota obtener(Long idMascota){
        return daoRegistroIngresoMascota.obtenerRegistroIngresoMascota(idMascota);
    }
}
