package com.ceiba.mascota.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.mascota.servicio.testdatabuilder.MascotaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Mascota;
import com.ceiba.usuario.puerto.repositorio.RepositorioMascota;
import com.ceiba.usuario.servicio.mascota.ServicioActualizarMascota;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioActualizarMascotaTest {

    @Test
    @DisplayName("Deberia validar la existencia previa de la mascota")
    void deberiaValidarLaExistenciaPreviaDelUsuario(){
        //arrange
        Mascota mascota = new MascotaTestDataBuilder().conId(1L).build();
        RepositorioMascota repositorioMascota = Mockito.mock(RepositorioMascota.class);
        Mockito.when(repositorioMascota.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarMascota servicioActualizarMascota = new ServicioActualizarMascota(repositorioMascota);
        //act - assert
        BasePrueba.assertThrows(
                () -> servicioActualizarMascota.ejecutar(mascota),
                ExcepcionDuplicidad.class,
                "La mascota no existe en el sistema"
        );
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio(){
        Mascota mascota = new MascotaTestDataBuilder().conId(1L).build();
        RepositorioMascota repositorioMascota = Mockito.mock(RepositorioMascota.class);
        Mockito.when(repositorioMascota.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarMascota servicioActualizarMascota = new ServicioActualizarMascota(repositorioMascota);
        //act
        servicioActualizarMascota.ejecutar(mascota);
        //assert
        Mockito.verify(
                repositorioMascota,
                Mockito.times(1)).actualizar(mascota);
        assertEquals("Zeus", mascota.getNombre());
        assertEquals("Doberman", mascota.getRaza());
        assertEquals("20Kg", mascota.getPeso());
    }
}
