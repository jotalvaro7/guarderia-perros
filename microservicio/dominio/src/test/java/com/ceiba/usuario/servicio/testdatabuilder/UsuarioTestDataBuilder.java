package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String numeroCelular;

    public UsuarioTestDataBuilder() {
        nombre = "Marcos";
        apellido = "Alonso";
        identificacion = "888000";
        numeroCelular = "5555";
    }

    public UsuarioTestDataBuilder conNumeroCelular(String numeroCelular){
        this.numeroCelular = numeroCelular;
        return this;
    }

    public UsuarioTestDataBuilder conIdentificacion(String identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public UsuarioTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public UsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,nombre,apellido,identificacion,numeroCelular);
    }
}
