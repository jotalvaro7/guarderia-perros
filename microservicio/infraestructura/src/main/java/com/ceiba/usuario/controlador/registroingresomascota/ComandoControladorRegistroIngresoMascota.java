package com.ceiba.usuario.controlador.registroingresomascota;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoRegistroIngresoMascota;
import com.ceiba.usuario.comando.manejador.registroingresomascota.ManejadorCrearRegistroIngresoMascota;
import com.ceiba.usuario.comando.manejador.registroingresomascota.ManejadorEliminarRegistroIngresoMascota;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro/ingreso")
@Api(tags = {"Controlador Comando Registro Ingreso Mascota"})
public class ComandoControladorRegistroIngresoMascota {

    private final ManejadorCrearRegistroIngresoMascota manejadorCrearRegistroIngresoMascota;
    private final ManejadorEliminarRegistroIngresoMascota manejadorEliminarRegistroIngresoMascota;

    public ComandoControladorRegistroIngresoMascota(ManejadorCrearRegistroIngresoMascota manejadorCrearRegistroIngresoMascota, ManejadorEliminarRegistroIngresoMascota manejadorEliminarRegistroIngresoMascota) {
        this.manejadorCrearRegistroIngresoMascota = manejadorCrearRegistroIngresoMascota;
        this.manejadorEliminarRegistroIngresoMascota = manejadorEliminarRegistroIngresoMascota;
    }

    @PostMapping
    @ApiOperation("Registrar Ingreso Mascota")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoRegistroIngresoMascota comandoRegistroIngresoMascota){
        return manejadorCrearRegistroIngresoMascota.ejecutar(comandoRegistroIngresoMascota);
    }

    @DeleteMapping("/{idMascota}")
    @ApiOperation("Eliminar Registro Ingreso Mascota")
    public void eliminar(@PathVariable Long idMascota){
        manejadorEliminarRegistroIngresoMascota.ejecutar(idMascota);
    }

}
