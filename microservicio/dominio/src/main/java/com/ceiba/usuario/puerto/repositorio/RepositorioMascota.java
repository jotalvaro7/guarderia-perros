package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Mascota;

public interface RepositorioMascota {

    /**
     * Permite crear una mascota
     * @param mascota
     * @return el id generado
     */
    Long crear(Mascota mascota);

    /**
     * Permite actualizar un mascota
     * @param mascota
     */
    void actualizar(Mascota mascota);

    /**
     * Permite eliminar una mascota
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una mascota con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
