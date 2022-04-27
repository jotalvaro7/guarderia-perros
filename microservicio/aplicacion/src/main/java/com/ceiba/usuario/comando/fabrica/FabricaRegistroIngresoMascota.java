package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoRegistroIngresoMascota;
import com.ceiba.usuario.modelo.entidad.RegistroIngresoMascota;
import org.springframework.stereotype.Component;

@Component
public class FabricaRegistroIngresoMascota {

    public RegistroIngresoMascota crear(ComandoRegistroIngresoMascota comandoRegistroIngresoMascota){
        return new RegistroIngresoMascota(
                comandoRegistroIngresoMascota.getIdMascota()
        );

    }

}
