package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoMascota;

import java.util.List;

public interface DaoMascota {

    /**
     * Permite obtener una mascota
     * @param id
     * @return
     */
    DtoMascota obtenerMascota(Long id);
}
