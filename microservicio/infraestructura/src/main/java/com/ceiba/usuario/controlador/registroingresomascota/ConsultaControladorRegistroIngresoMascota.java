package com.ceiba.usuario.controlador.registroingresomascota;

import com.ceiba.usuario.consulta.registroingresomascota.ManejadorObtenerRegistroIngresoMascota;
import com.ceiba.usuario.modelo.dto.DtoRegistroIngresoMascota;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("registro/ingreso")
@Api(tags = {"Controlador Consulta Registro Ingreso Mascota"})
public class ConsultaControladorRegistroIngresoMascota {

    private final ManejadorObtenerRegistroIngresoMascota manejadorObtenerRegistroIngresoMascota;

    public ConsultaControladorRegistroIngresoMascota(ManejadorObtenerRegistroIngresoMascota manejadorObtenerRegistroIngresoMascota) {
        this.manejadorObtenerRegistroIngresoMascota = manejadorObtenerRegistroIngresoMascota;
    }

    @GetMapping("/mascota/{idMascota}")
    @ApiOperation("Obtener Registro Ingreso De La Mascota Por Id Mascota")
    public DtoRegistroIngresoMascota obtenerPorIdMascota(@PathVariable Long idMascota){
        return manejadorObtenerRegistroIngresoMascota.obtener(idMascota);
    }
}
