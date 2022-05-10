package com.ceiba.usuario.adaptador.dao.mascota;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoMascotaNombreFecha;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class MapeoNombreFechaMascota implements RowMapper<DtoMascotaNombreFecha>, MapperResult {

    @Override
    public DtoMascotaNombreFecha mapRow(ResultSet rs, int rowNum) throws SQLException {
        String nombre = rs.getString("nombre");
        LocalDateTime fechaIngreso = extraerLocalDateTime(rs,"fechaIngreso");
        return new DtoMascotaNombreFecha(nombre, fechaIngreso);
    }
}
