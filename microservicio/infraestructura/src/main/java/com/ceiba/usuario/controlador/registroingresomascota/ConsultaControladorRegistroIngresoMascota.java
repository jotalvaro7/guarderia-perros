package com.ceiba.usuario.controlador.registroingresomascota;

import com.ceiba.usuario.consulta.registroingresomascota.ManejadorObtenerRegistroIngresoMascota;
import com.ceiba.usuario.modelo.dto.DtoRegistroIngresoMascota;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registro/ingreso")
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
