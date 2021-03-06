package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String numeroCelular;

    public ComandoUsuarioTestDataBuilder() {
        nombre = "Pepe";
        apellido = "Perez";
        identificacion = "00001111";
        numeroCelular = "303030";
    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id,nombre,apellido,identificacion,numeroCelular);
    }
}
