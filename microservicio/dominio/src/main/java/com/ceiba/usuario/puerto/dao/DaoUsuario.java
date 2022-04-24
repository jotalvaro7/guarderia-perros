package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoUsuario {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoUsuario> listar();

    /**
     * Permite obtener un usuario
     * @param id
     * @return
     */
    DtoUsuario obtenerUsuario(Long id);
}
