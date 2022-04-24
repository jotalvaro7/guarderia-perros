package com.ceiba.usuario.consulta.usuario;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerUsuario {

    private final DaoUsuario daoUsuario;

    public ManejadorObtenerUsuario(DaoUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public DtoUsuario obtener(Long id){
        return this.daoUsuario.obtenerUsuario(id);
    }


}
