package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoMascota;
import com.ceiba.usuario.modelo.dto.DtoMascotaNombreFecha;

import java.util.List;

public interface DaoMascota {


    /**
     * Permite listar mascotas del usuario
     * @return las mascotas de usuario
     */
    List<DtoMascota> listarMascotasDeUsuario(Long id);

    /**
     * Permite obtener una mascota
     * @param id
     * @return
     */
    DtoMascota obtenerMascota(Long id);

    DtoMascotaNombreFecha obtenerNombreFechaIngresoMascota(Long id);
}
