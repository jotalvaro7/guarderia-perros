package com.ceiba.facturamascota.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.facturamascota.servicio.testdatabuilder.FacturaMascotaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.FacturaMascota;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FacturaMascotaTest {

    @Test
    @DisplayName("Deberia Crear Correctamente La Factura")
    void deberiaCrearCorrectamenteLaFactura() {

        FacturaMascota facturaMascota = new FacturaMascotaTestDataBuilder().build();

        LocalDateTime fechaIngreso = LocalDateTime.of(2022, 04, 27, 18, 00,00);
        LocalDateTime fechaSalida = LocalDateTime.of(2022,04,28,18,00,00);

        assertEquals("Zeus", facturaMascota.getNombreMascota());
        assertEquals(fechaIngreso, facturaMascota.getFechaIngreso());
        assertEquals(fechaSalida, facturaMascota.getFechaSalida());
        assertNotEquals("", facturaMascota.getTotalTiempoEnGuarderia());
        assertEquals(184000L, facturaMascota.getPrecioAPagar());

    }

    @Test
    @DisplayName("Deberia Lanzar Una Excepcion cuando El Nombre De La Mascota Es Vacio")
    void deberiaLanzarUnaExcepcionCuandoElNombreDeLaMascotaEsVacio() {

        FacturaMascotaTestDataBuilder facturaMascotaTestDataBuilder = new FacturaMascotaTestDataBuilder().conNombreMascota("");


        BasePrueba.assertThrows(facturaMascotaTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                "Se debe ingresar el nombre de la mascota");
    }

    @Test
    @DisplayName("Deberia Lanzar Una Excepcion cuando El Nombre De La Mascota Es Null")
    void deberiaLanzarUnaExcepcionCuandoElNombreDeLaMascotaEsNull() {

        FacturaMascotaTestDataBuilder facturaMascotaTestDataBuilder = new FacturaMascotaTestDataBuilder().conNombreMascota(null);

        BasePrueba.assertThrows(facturaMascotaTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                "Se debe ingresar el nombre de la mascota");
    }


    @Test
    @DisplayName("Deberia Lanzar Una Excepcion cuando La Fecha de Ingreso De La Mascota Es Null")
    void deberiaLanzarUnaExcepcionCuandoLaFechaDeIngresoEsNull() {

        FacturaMascotaTestDataBuilder facturaMascotaTestDataBuilder = new FacturaMascotaTestDataBuilder().conFechaIngreso(null);

        BasePrueba.assertThrows(facturaMascotaTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                "Se debe ingresar la fecha de ingreso de la mascota");
    }

    @Test
    @DisplayName("Deberia Lanzar Una Excepcion cuando La Fecha de Salida De La Mascota Es Null")
    void deberiaLanzarUnaExcepcionCuandoLaFechaDeSalidaEsNull() {

        FacturaMascotaTestDataBuilder facturaMascotaTestDataBuilder = new FacturaMascotaTestDataBuilder().conFechaSalida(null);

        BasePrueba.assertThrows(facturaMascotaTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                "Se debe ingresar la fecha de salida de la mascota");
    }


    @Test
    @DisplayName("Deberia Lanzar Una Excepcion  Cuando El Precio A Pagar De La Mascota Es Null")
    void deberiaLanzarUnaExcepcionCuandoELPrecioAPagarEsNull() {

        FacturaMascotaTestDataBuilder facturaMascotaTestDataBuilder = new FacturaMascotaTestDataBuilder().conPrecioAPagar(null);

        BasePrueba.assertThrows(facturaMascotaTestDataBuilder::build,
                ExcepcionValorObligatorio.class,
                "Se debe ingresar el precio a pagar");
    }
}
