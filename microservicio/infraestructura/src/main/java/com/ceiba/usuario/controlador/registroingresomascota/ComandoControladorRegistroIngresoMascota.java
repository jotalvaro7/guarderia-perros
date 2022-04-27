package com.ceiba.usuario.controlador.registroingresomascota;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoRegistroIngresoMascota;
import com.ceiba.usuario.comando.manejador.registroingresomascota.ManejadorCrearRegistroIngresoMascota;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registro/ingreso")
@Api(tags = {"Controlador Comando Registro Ingreso Mascota"})
public class ComandoControladorRegistroIngresoMascota {

    private final ManejadorCrearRegistroIngresoMascota manejadorCrearRegistroIngresoMascota;

    public ComandoControladorRegistroIngresoMascota(ManejadorCrearRegistroIngresoMascota manejadorCrearRegistroIngresoMascota) {
        this.manejadorCrearRegistroIngresoMascota = manejadorCrearRegistroIngresoMascota;
    }

    @PostMapping
    @ApiOperation("Registrar Ingreso Mascota")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoRegistroIngresoMascota comandoRegistroIngresoMascota){
        return manejadorCrearRegistroIngresoMascota.ejecutar(comandoRegistroIngresoMascota);
    }

}
