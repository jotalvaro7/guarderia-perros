package com.ceiba.usuario.adaptador.repositorio.mascota;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Mascota;
import com.ceiba.usuario.puerto.repositorio.RepositorioMascota;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMascotaMysql implements RepositorioMascota {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="usuario", value="crearMascota")
    private static String sqlCrear;

    @SqlStatement(namespace = "usuario", value = "existeMascotaPorId")
    private static String sqlExisteMascotaPorId;

    @SqlStatement(namespace = "usuario", value = "actualizarMascota")
    private static String sqlActualizarMascota;

    @SqlStatement(namespace = "usuario", value = "eliminarMascota")
    private static String sqlEliminarMascota;

    public RepositorioMascotaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Mascota mascota) {
        return this.customNamedParameterJdbcTemplate.crear(mascota, sqlCrear);
    }

    @Override
    public void actualizar(Mascota mascota) {
        this.customNamedParameterJdbcTemplate.actualizar(mascota, sqlActualizarMascota);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarMascota, paramSource);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteMascotaPorId,paramSource, Boolean.class);
    }
}
