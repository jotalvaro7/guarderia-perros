package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.RegistroIngresoMascota;


public interface RepositorioRegistroIngresoMascota {

    /**
     * Permite crear una factura
     * @param registroIngresoMascota
     * @return el id generado
     */
    Long crear(RegistroIngresoMascota registroIngresoMascota);
}
