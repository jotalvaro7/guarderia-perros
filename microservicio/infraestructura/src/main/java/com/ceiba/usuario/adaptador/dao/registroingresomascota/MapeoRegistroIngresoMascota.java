package com.ceiba.usuario.adaptador.dao.registroingresomascota;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoRegistroIngresoMascota;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoRegistroIngresoMascota implements RowMapper<DtoRegistroIngresoMascota>, MapperResult {


    @Override
    public DtoRegistroIngresoMascota mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        Long idMascota = resultSet.getLong("idMascota");
        LocalDateTime fechaIngreso = extraerLocalDateTime(resultSet,"fechaIngreso");
        return new DtoRegistroIngresoMascota(id, idMascota, fechaIngreso) ;
    }
}
