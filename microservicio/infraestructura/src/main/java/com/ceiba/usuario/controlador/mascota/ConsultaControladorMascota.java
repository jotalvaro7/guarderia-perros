package com.ceiba.usuario.controlador.mascota;


import com.ceiba.usuario.consulta.mascota.ManejadorObtenerMascota;
import com.ceiba.usuario.modelo.dto.DtoMascota;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mascotas")
@Api(tags = {"Controlador Consulta Mascota"})
public class ConsultaControladorMascota {

    private final ManejadorObtenerMascota manejadorObtenerMascota;

    public ConsultaControladorMascota(ManejadorObtenerMascota manejadorObtenerMascota) {
        this.manejadorObtenerMascota = manejadorObtenerMascota;
    }

    @GetMapping("/{id}")
    @ApiOperation("Listar Mascota por Id")
    public DtoMascota listarPorId(@PathVariable Long id){
        return manejadorObtenerMascota.obtener(id);
    }
}
