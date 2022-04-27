package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Mascota {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PERRO = "Se debe ingresar el nombre de la mascota";
    private static final String SE_DEBE_INGRESAR_LA_RAZA_DEL_PERRO = "Se debe ingresar la raza de la mascota";
    private static final String SE_DEBE_INGRESAR_EL_PESO_DEL_PERRO = "Se debe ingresar el peso de la mascota";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO = "Se debe ingresar el id del usuario";


    private Long id;
    private String nombre;
    private String raza;
    private String peso;
    private Long idUsuario;

    public Mascota(Long id, String nombre, String raza, String peso, Long idUsuario) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PERRO);
        validarObligatorio(raza, SE_DEBE_INGRESAR_LA_RAZA_DEL_PERRO);
        validarObligatorio(peso, SE_DEBE_INGRESAR_EL_PESO_DEL_PERRO);
        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO);

        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.peso = peso;
        this.idUsuario = idUsuario;
    }


}
