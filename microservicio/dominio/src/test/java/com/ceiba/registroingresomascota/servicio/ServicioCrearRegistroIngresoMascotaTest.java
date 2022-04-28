package com.ceiba.registroingresomascota.servicio;

import com.ceiba.registroingresomascota.servicio.testdatabuilder.RegistroIngresoMascotaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.RegistroIngresoMascota;
import com.ceiba.usuario.puerto.repositorio.RepositorioRegistroIngresoMascota;
import com.ceiba.usuario.servicio.registroingresomascota.ServicioCrearRegistroIngresoMascota;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

class ServicioCrearRegistroIngresoMascotaTest {

    @Test
    void deberiaCrearLaMascotaDeManeraCorrecta() {
        //arrange
        RegistroIngresoMascota registroIngresoMascota = new RegistroIngresoMascotaTestDataBuilder().build();
        RepositorioRegistroIngresoMascota repositorioRegistroIngresoMascota = Mockito.mock(RepositorioRegistroIngresoMascota.class);
        Mockito.when(repositorioRegistroIngresoMascota.crear(registroIngresoMascota)).thenReturn(1L);
        ServicioCrearRegistroIngresoMascota servicioCrearRegistroIngresoMascota = new ServicioCrearRegistroIngresoMascota(repositorioRegistroIngresoMascota);

        Long id = servicioCrearRegistroIngresoMascota.ejecutar(registroIngresoMascota);

        assertEquals(1L, id);
        Mockito.verify(repositorioRegistroIngresoMascota, Mockito.times(1)).crear(registroIngresoMascota);

    }
}
