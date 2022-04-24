package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoMascota;
import com.ceiba.usuario.modelo.entidad.Mascota;
import org.springframework.stereotype.Component;

@Component
public class FabricaMascota {

    public Mascota crear(ComandoMascota comandoMascota){
        return new Mascota(
                comandoMascota.getId(),
                comandoMascota.getNombre(),
                comandoMascota.getRaza(),
                comandoMascota.getPeso(),
                comandoMascota.getIdUsuario()
        );
    }
}
