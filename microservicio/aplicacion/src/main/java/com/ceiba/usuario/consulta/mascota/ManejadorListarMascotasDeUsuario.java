package com.ceiba.usuario.consulta.mascota;

import com.ceiba.usuario.modelo.dto.DtoMascota;
import com.ceiba.usuario.puerto.dao.DaoMascota;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarMascotasDeUsuario {

    private final DaoMascota daoMascota;

    public ManejadorListarMascotasDeUsuario(DaoMascota daoMascota) {
        this.daoMascota = daoMascota;
    }

    public List<DtoMascota> ejecutar(Long idUsuario){
        return daoMascota.listarMascotasDeUsuario(idUsuario);
    }
}
