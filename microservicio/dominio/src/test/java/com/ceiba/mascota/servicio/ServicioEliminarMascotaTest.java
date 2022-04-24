package com.ceiba.mascota.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioMascota;
import com.ceiba.usuario.servicio.mascota.ServicioEliminarMascota;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarMascotaTest {

    @Test
    @DisplayName("Deberia eliminar la mascota llamando al repositorio")
    void deberiaEliminarLaMascotaLlamandoAlRepositorio() {
        RepositorioMascota repositorioMascota = Mockito.mock(RepositorioMascota.class);
        ServicioEliminarMascota servicioEliminarMascota = new ServicioEliminarMascota(repositorioMascota);

        servicioEliminarMascota.ejecutar(1L);
        Mockito.verify(repositorioMascota, Mockito.times(1)).eliminar(1L);
    }
}
