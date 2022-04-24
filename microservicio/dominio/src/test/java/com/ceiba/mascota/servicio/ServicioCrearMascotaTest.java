package com.ceiba.mascota.servicio;

import com.ceiba.mascota.servicio.testdatabuilder.MascotaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Mascota;
import com.ceiba.usuario.puerto.repositorio.RepositorioMascota;
import com.ceiba.usuario.servicio.mascota.ServicioCrearMascota;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioCrearMascotaTest {

    @Test
    @DisplayName("Deberia crear la mascota de manera correcta")
    void deberiaCrearLaMascotaDeManeraCorrecta(){
        //arrange
        Mascota mascota = new MascotaTestDataBuilder().build();
        RepositorioMascota repositorioMascota = Mockito.mock(RepositorioMascota.class);
        Mockito.when(repositorioMascota.existePorId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioMascota.crear(mascota)).thenReturn(20L);
        ServicioCrearMascota servicioCrearMascota = new ServicioCrearMascota(repositorioMascota);
        //act
        Long idMascota = servicioCrearMascota.ejecutar(mascota);
        //assert
        assertEquals(20L, idMascota);
        Mockito.verify(repositorioMascota, Mockito.times(1)).crear(mascota);
    }
}
