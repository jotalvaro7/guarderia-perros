package com.ceiba.mascota.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.mascota.servicio.testdatabuilder.MascotaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Mascota;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class MascotaTest {


    @Test
    @DisplayName("Deberia crear correctamente la mascota")
    void deberiaCrearCorrectamenteLaMascota() {
        //arrange
        Mascota mascota = new MascotaTestDataBuilder().build();

        //act - assert
        assertEquals(1L, mascota.getId());
        assertEquals("Zeus", mascota.getNombre());
        assertEquals("Doberman", mascota.getRaza());
        assertEquals("20Kg", mascota.getPeso());
        assertEquals(2L, mascota.getIdUsuario());


    }

    @Test
    @DisplayName("Deberia crear correctamente la mascota con otros datos")
    void deberiaCrearCorrectamenteLaMascotaConOtrosDatos() {
        //arrange
        Mascota mascota = new MascotaTestDataBuilder()
                .conId(20L)
                .conNombre("Auron")
                .conRaza("Bullterrier")
                .conPeso("7Kg")
                .conIdUsuario(2L).build();

        //act - assert
        assertEquals(20L, mascota.getId());
        assertEquals("Auron", mascota.getNombre());
        assertEquals("Bullterrier", mascota.getRaza());
        assertEquals("7Kg", mascota.getPeso());
        assertEquals(2L, mascota.getIdUsuario());
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el nombre de la mascota es vacio")
    void deberiaLanzarUnaExepcionCuandoElNombreDeLaMascotaEsVacio() {
        // arrange
        MascotaTestDataBuilder mascotaTestDataBuilder = new MascotaTestDataBuilder().conNombre("");
        // act - assert
        BasePrueba.assertThrows(mascotaTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                "Se debe ingresar el nombre de la mascota");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el nombre de la mascota es null")
    void deberiaLanzarUnaExepcionCuandoElNombreDeLaMascotaEsNull() {
        // arrange
        MascotaTestDataBuilder mascotaTestDataBuilder = new MascotaTestDataBuilder().conNombre(null);
        // act - assert
        BasePrueba.assertThrows(mascotaTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                "Se debe ingresar el nombre de la mascota");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando la raza de la mascota es vacio")
    void deberiaLanzarUnaExepcionCuandoLaRazaDeLaMascotaEsVacio() {
        // arrange
        MascotaTestDataBuilder mascotaTestDataBuilder = new MascotaTestDataBuilder().conRaza("");
        // act - assert
        BasePrueba.assertThrows(mascotaTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                "Se debe ingresar la raza de la mascota");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando la raza de la mascota es null")
    void deberiaLanzarUnaExepcionCuandoLaRazaDeLaMascotaEsNull() {
        // arrange
        MascotaTestDataBuilder mascotaTestDataBuilder = new MascotaTestDataBuilder().conRaza(null);
        // act - assert
        BasePrueba.assertThrows(mascotaTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                "Se debe ingresar la raza de la mascota");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el peso de la mascota es vacio")
    void deberiaLanzarUnaExepcionCuandoElPesoDeLaMascotaEsVacio() {
        // arrange
        MascotaTestDataBuilder mascotaTestDataBuilder = new MascotaTestDataBuilder().conPeso("");
        // act - assert
        BasePrueba.assertThrows(mascotaTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                "Se debe ingresar el peso de la mascota");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el peso de la mascota es null")
    void deberiaLanzarUnaExepcionCuandoElPesoDeLaMascotaEsNull() {
        // arrange
        MascotaTestDataBuilder mascotaTestDataBuilder = new MascotaTestDataBuilder().conPeso(null);
        // act - assert
        BasePrueba.assertThrows(mascotaTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                "Se debe ingresar el peso de la mascota");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el idUsuario de la mascota es null")
    void deberiaLanzarUnaExepcionCuandoElIdUsuarioDeLaMascotaEsNull() {
        // arrange
        MascotaTestDataBuilder mascotaTestDataBuilder = new MascotaTestDataBuilder().conIdUsuario(null);
        // act - assert
        BasePrueba.assertThrows(mascotaTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                "Se debe ingresar el id del usuario");
    }

}
