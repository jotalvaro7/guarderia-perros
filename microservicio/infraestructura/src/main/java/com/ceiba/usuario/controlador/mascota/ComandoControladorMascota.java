package com.ceiba.usuario.controlador.mascota;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoMascota;
import com.ceiba.usuario.comando.manejador.mascota.ManejadorActualizarMascota;
import com.ceiba.usuario.comando.manejador.mascota.ManejadorCrearMascota;
import com.ceiba.usuario.comando.manejador.mascota.ManejadorEliminarMascota;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/mascotas")
@Api(tags = {"Controlador comando mascota"})
public class ComandoControladorMascota {

    private final ManejadorCrearMascota manejadorCrearMascota;
    private final ManejadorActualizarMascota manejadorActualizarMascota;
    private final ManejadorEliminarMascota manejadorEliminarMascota;

    @Autowired
    public ComandoControladorMascota(ManejadorCrearMascota manejadorCrearMascota, ManejadorActualizarMascota manejadorActualizarMascota, ManejadorEliminarMascota manejadorEliminarMascota) {
        this.manejadorCrearMascota = manejadorCrearMascota;
        this.manejadorActualizarMascota = manejadorActualizarMascota;
        this.manejadorEliminarMascota = manejadorEliminarMascota;
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

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar Mascota")
    public void eliminar(@PathVariable Long id){
        manejadorEliminarMascota.ejecutar(id);
    }
}
