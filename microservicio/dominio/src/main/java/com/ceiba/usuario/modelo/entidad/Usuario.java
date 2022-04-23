package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_EL_APELLIDO_DE_USUARIO = "Se debe ingresar el apellido de usuario";
    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION_DE_USUARIO = "Se debe ingresar la identificacion de usuario";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_CELULAR = "Se debe ingresar el numero de celular de usuario";


    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String numeroCelular;

    public Usuario(Long id, String nombre, String apellido, String identificacion, String numeroCelular) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(apellido, SE_DEBE_INGRESAR_EL_APELLIDO_DE_USUARIO);
        validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION_DE_USUARIO);
        validarObligatorio(numeroCelular, SE_DEBE_INGRESAR_EL_NUMERO_DE_CELULAR);

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.numeroCelular = numeroCelular;
    }

}
