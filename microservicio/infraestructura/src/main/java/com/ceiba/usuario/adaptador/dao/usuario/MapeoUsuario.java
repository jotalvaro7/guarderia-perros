package com.ceiba.usuario.adaptador.dao.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoUsuario implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        String identificacion = resultSet.getString("identificacion");
        String numeroCelular = resultSet.getString("numeroCelular");

        return new DtoUsuario(id,nombre,apellido,identificacion, numeroCelular);

    }

}
