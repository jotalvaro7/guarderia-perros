package com.ceiba.usuario.adaptador.dao.mascota;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoMascota;
import com.ceiba.usuario.puerto.dao.DaoMascota;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoMascotaMysql implements DaoMascota {

    @SqlStatement(namespace = "usuario", value = "listarMascotasDeUsuario")
    private static String sqlListarMascotasDeUsuario;
    @SqlStatement(namespace = "usuario", value = "listarMascotaPorId")
    private static String sqlListarMascotaPorId;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoMascotaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoMascota> listarMascotasDeUsuario(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idUsuario);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarMascotasDeUsuario, paramSource, new MapeoMascota());
    }

    @Override
    public DtoMascota obtenerMascota(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(sqlListarMascotaPorId, paramSource, new MapeoMascota());
    }

}
