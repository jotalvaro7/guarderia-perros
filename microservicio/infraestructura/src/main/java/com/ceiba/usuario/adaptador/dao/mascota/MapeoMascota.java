package com.ceiba.usuario.adaptador.dao.mascota;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoMascota;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoMascota implements RowMapper<DtoMascota>, MapperResult {

    @Override
    public DtoMascota mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String raza = resultSet.getString("raza");
        String peso = resultSet.getString("peso");
        Long idUsuario = resultSet.getLong("idUsuario");

        return new DtoMascota(id,nombre,raza,peso,idUsuario);

    }

}
