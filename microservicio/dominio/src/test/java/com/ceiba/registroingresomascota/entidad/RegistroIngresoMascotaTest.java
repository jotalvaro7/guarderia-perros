package com.ceiba.registroingresomascota.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.registroingresomascota.servicio.testdatabuilder.RegistroIngresoMascotaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.RegistroIngresoMascota;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RegistroIngresoMascotaTest {

    @Test
    @DisplayName("Deberia crear corrrectamente el registro de ingreso de la mascota")
    void deberiaCrearCorrectamenteElRegistroDeIngresoDeLaMascota() {
        //arrange
        RegistroIngresoMascota registroIngresoMascota = new RegistroIngresoMascotaTestDataBuilder().build();

        //act-assert
        assertEquals(1L, registroIngresoMascota.getId());
        assertEquals(1L, registroIngresoMascota.getIdMascota());
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el id de la mascota es null")
    void deberiaLanzarUnaExcepcionCuandoElIdDeLaMascotaEsNull(){
    RegistroIngresoMascotaTestDataBuilder registroIngresoMascotaTestDataBuilder  = new RegistroIngresoMascotaTestDataBuilder().conIdMascota(null);

    BasePrueba.assertThrows(registroIngresoMascotaTestDataBuilder::build,
            ExcepcionValorObligatorio.class, "Se debe ingresar el Id de la mascota");
    }


    @Test
    @DisplayName("Deberia crear fecha de ingreso")
    void deberiaCrearFechaDeIngreso(){
        RegistroIngresoMascota registroIngresoMascota = new RegistroIngresoMascotaTestDataBuilder().build();
        assertNotNull(registroIngresoMascota.getFechaIngreso());
    }

}
