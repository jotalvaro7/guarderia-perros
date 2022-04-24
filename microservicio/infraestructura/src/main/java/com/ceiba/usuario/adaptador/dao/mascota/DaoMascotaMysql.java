package com.ceiba.usuario.adaptador.dao.mascota;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.adaptador.dao.usuario.MapeoUsuario;
import com.ceiba.usuario.modelo.dto.DtoMascota;
import com.ceiba.usuario.puerto.dao.DaoMascota;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoMascotaMysql implements DaoMascota {

    @SqlStatement(namespace = "usuario", value = "listarMascotaPorId")
    public static String sqlListarMascotaPorId;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoMascotaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
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
