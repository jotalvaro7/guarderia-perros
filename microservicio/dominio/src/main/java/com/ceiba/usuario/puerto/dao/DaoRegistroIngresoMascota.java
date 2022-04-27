package com.ceiba.usuario.puerto.dao;


import com.ceiba.usuario.modelo.dto.DtoRegistroIngresoMascota;

public interface DaoRegistroIngresoMascota {

    /**
     * Permite obtener el registro de ingreso de una mascota
     * @param id
     * @return
     */
    DtoRegistroIngresoMascota obtenerRegistroIngresoMascota(Long id);
}
