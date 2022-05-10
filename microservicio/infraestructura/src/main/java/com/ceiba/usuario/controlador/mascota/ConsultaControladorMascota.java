package com.ceiba.usuario.controlador.mascota;


import com.ceiba.usuario.consulta.mascota.ManejadorObtenerMascota;
import com.ceiba.usuario.consulta.mascota.ManejadorListarMascotasDeUsuario;
import com.ceiba.usuario.modelo.dto.DtoMascota;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mascotas")
@Api(tags = {"Controlador Consulta Mascota"})
public class ConsultaControladorMascota {

    private final ManejadorObtenerMascota manejadorObtenerMascota;
    private final ManejadorListarMascotasDeUsuario manejadorListarMascotasDeUsuario;

    public ConsultaControladorMascota(ManejadorObtenerMascota manejadorObtenerMascota, ManejadorListarMascotasDeUsuario manejadorListarMascotasDeUsuario) {
        this.manejadorObtenerMascota = manejadorObtenerMascota;
        this.manejadorListarMascotasDeUsuario = manejadorListarMascotasDeUsuario;
    }

    @GetMapping("/usuario/{idUsuario}")
    @ApiOperation("Listar mascotas de usuario")
    public List<DtoMascota> listarMascotasDeUsuario(@PathVariable Long idUsuario){
        return manejadorListarMascotasDeUsuario.ejecutar(idUsuario);
    }

    @GetMapping("/{id}")
    @ApiOperation("Listar Mascota por Id")
    public DtoMascota listarPorId(@PathVariable Long id){
        return manejadorObtenerMascota.obtener(id);
    }
}
