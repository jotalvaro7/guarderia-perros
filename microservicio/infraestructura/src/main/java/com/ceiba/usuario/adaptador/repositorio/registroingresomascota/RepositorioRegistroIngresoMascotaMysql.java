package com.ceiba.usuario.adaptador.repositorio.registroingresomascota;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.RegistroIngresoMascota;
import com.ceiba.usuario.puerto.repositorio.RepositorioRegistroIngresoMascota;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioRegistroIngresoMascotaMysql implements RepositorioRegistroIngresoMascota {

    @SqlStatement(namespace="usuario", value="crearRegistroIngresoMascota")
    private static String sqlCrear;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;


    public RepositorioRegistroIngresoMascotaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(RegistroIngresoMascota registroIngresoMascota) {
        return customNamedParameterJdbcTemplate.crear(registroIngresoMascota, sqlCrear);
    }
}
