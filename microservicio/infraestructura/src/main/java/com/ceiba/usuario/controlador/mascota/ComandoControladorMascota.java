package com.ceiba.usuario.controlador.mascota;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoMascota;
import com.ceiba.usuario.comando.manejador.mascota.ManejadorActualizarMascota;
import com.ceiba.usuario.comando.manejador.mascota.ManejadorCrearMascota;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mascotas")
@Api(tags = {"Controlador comando mascota"})
public class ComandoControladorMascota {

    private final ManejadorCrearMascota manejadorCrearMascota;
    private final ManejadorActualizarMascota manejadorActualizarMascota;

    @Autowired
    public ComandoControladorMascota(ManejadorCrearMascota manejadorCrearMascota, ManejadorActualizarMascota manejadorActualizarMascota) {
        this.manejadorCrearMascota = manejadorCrearMascota;
        this.manejadorActualizarMascota = manejadorActualizarMascota;
    }

    @PostMapping
    @ApiOperation("Crear Mascota")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoMascota comandoMascota){
        return manejadorCrearMascota.ejecutar(comandoMascota);
    }

    @PutMapping("/{id}")
    @ApiOperation("Actualizar Mascota")
    public void actualizar(@RequestBody ComandoMascota comandoMascota, @PathVariable Long id){
        comandoMascota.setId(id);
        manejadorActualizarMascota.ejecutar(comandoMascota);
    }
}
