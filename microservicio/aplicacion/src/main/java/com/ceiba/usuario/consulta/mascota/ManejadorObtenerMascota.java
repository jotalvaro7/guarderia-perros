package com.ceiba.usuario.consulta.mascota;

import com.ceiba.usuario.modelo.dto.DtoMascota;
import com.ceiba.usuario.puerto.dao.DaoMascota;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerMascota {

    private  final DaoMascota daoMascota;

    public ManejadorObtenerMascota(DaoMascota daoMascota) {
        this.daoMascota = daoMascota;
    }

    public DtoMascota obtener(Long id){
        return this.daoMascota.obtenerMascota(id);
    }
}
