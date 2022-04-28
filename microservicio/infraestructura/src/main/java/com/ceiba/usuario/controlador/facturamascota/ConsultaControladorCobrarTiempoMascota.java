package com.ceiba.usuario.controlador.facturamascota;

import com.ceiba.usuario.consulta.facturamascota.ManejadorCobrarTiempoMascota;
import com.ceiba.usuario.modelo.entidad.FacturaMascota;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cobrar")
@Api(tags = {"Controlador Cobrar"})
public class ConsultaControladorCobrarTiempoMascota {

    private final ManejadorCobrarTiempoMascota manejadorCobrarTiempoMascota;

    public ConsultaControladorCobrarTiempoMascota(ManejadorCobrarTiempoMascota manejadorCobrarTiempoMascota) {
        this.manejadorCobrarTiempoMascota = manejadorCobrarTiempoMascota;
    }


    @GetMapping("/{id}")
    @ApiOperation("El tiempo de la mascota")
    public FacturaMascota cobrar(@PathVariable Long id){
        return manejadorCobrarTiempoMascota.ejecutar(id);
    }

}
