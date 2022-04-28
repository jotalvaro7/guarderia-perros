package com.ceiba.usuario.adaptador.repositorio.registroingresomascota;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.RegistroIngresoMascota;
import com.ceiba.usuario.puerto.repositorio.RepositorioRegistroIngresoMascota;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioRegistroIngresoMascotaMysql implements RepositorioRegistroIngresoMascota {

    @SqlStatement(namespace="usuario", value="crearRegistroIngresoMascota")
    private static String sqlCrear;

    @SqlStatement(namespace = "usuario", value = "eliminarRegistroIngresoMascotaPorIdMascota")
    private static String sqlEliminar;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;


    public RepositorioRegistroIngresoMascotaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(RegistroIngresoMascota registroIngresoMascota) {
        return customNamedParameterJdbcTemplate.crear(registroIngresoMascota, sqlCrear);
    }

    @Override
    public void eliminar(Long idMascota) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idMascota);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);

    }
}
