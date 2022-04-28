package com.ceiba.usuario.adaptador.dao.registroingresomascota;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoRegistroIngresoMascota;
import com.ceiba.usuario.puerto.dao.DaoRegistroIngresoMascota;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoRegistroIngresoMascotaMysql implements DaoRegistroIngresoMascota {

    @SqlStatement(namespace = "usuario", value = "listarRegistroIngresoDeMascotaPorIdDeMascota")
    private static String sqlListarRegistroDeIngresoMascota;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoRegistroIngresoMascotaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public DtoRegistroIngresoMascota obtenerRegistroIngresoMascota(Long idMascota) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", idMascota);
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(sqlListarRegistroDeIngresoMascota, parameterSource, new MapeoRegistroIngresoMascota());
    }
}
