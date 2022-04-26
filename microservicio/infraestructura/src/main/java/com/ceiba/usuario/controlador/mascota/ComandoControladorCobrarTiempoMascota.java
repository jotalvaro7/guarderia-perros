package com.ceiba.usuario.controlador.mascota;

import com.ceiba.usuario.consulta.mascota.ManejadorCobrarTiempoMascota;
import com.ceiba.usuario.modelo.entidad.FacturaMascota;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cobrar")
@Api(tags = {"Controlador Cobrar"})
public class ComandoControladorCobrarTiempoMascota {

    private final ManejadorCobrarTiempoMascota manejadorCobrarTiempoMascota;

    public ComandoControladorCobrarTiempoMascota(ManejadorCobrarTiempoMascota manejadorCobrarTiempoMascota) {
        this.manejadorCobrarTiempoMascota = manejadorCobrarTiempoMascota;
    }


    @GetMapping("/{id}")
    @ApiOperation("El tiempo de la mascota")
    public FacturaMascota cobrar(@PathVariable Long id){
        return manejadorCobrarTiempoMascota.ejecutar(id);
    }

}
