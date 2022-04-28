package com.ceiba.registroingresomascota.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioRegistroIngresoMascota;
import com.ceiba.usuario.servicio.registroingresomascota.ServicioEliminarRegistroIngresoMascota;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarRegistroIngresoMascotaTest {

    @Test
    @DisplayName("Deberia Eliminar Registro Ingreso Mascota")
    void deberiaEliminarRegistroIngresoMascota(){
        RepositorioRegistroIngresoMascota repositorioRegistroIngresoMascota = Mockito.mock(RepositorioRegistroIngresoMascota.class);
        ServicioEliminarRegistroIngresoMascota servicioEliminarRegistroIngresoMascota = new ServicioEliminarRegistroIngresoMascota(repositorioRegistroIngresoMascota);

        servicioEliminarRegistroIngresoMascota.ejecutar(1L);
        Mockito.verify(repositorioRegistroIngresoMascota, Mockito.times(1)).eliminar(1L);

    }
}
