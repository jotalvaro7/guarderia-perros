package com.ceiba.mascota.servicio;

import com.ceiba.usuario.modelo.entidad.FacturaMascota;

import com.ceiba.usuario.servicio.facturamascota.ServicioCobrarTiempoMascota;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ServicioCobrarTiempoMascotaTest {

    @Test
    @DisplayName("Deberia calcular el precio de la factura sin descuentos mayor a la minima y menor al descuento silver")
    void deberiaCalcularElPrecioDeLaFacturaSinAplicarDescuentos() {
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusHours(-5);
        FacturaMascota facturaMascota = new FacturaMascota("Kaiser", fechaIngreso, LocalDateTime.now(), "", 0L);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota();
        //act
        FacturaMascota facturaMascotaR = servicioCobrarTiempoMascota.ejecutar(facturaMascota);
        //assert
        assertEquals(5000, (long) facturaMascotaR.getPrecioAPagar());
        assertEquals("Kaiser", facturaMascotaR.getNombreMascota());
    }

    @Test
    @DisplayName("Deberia calcular el precio fijo si el tiempo es 1 semana exactamente")
    void deberiaCalcularPrecioAPagarConPrecioFijoSiSemanaEs1() {
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusWeeks(-1);
        FacturaMascota facturaMascota = new FacturaMascota("Kaiser", fechaIngreso, LocalDateTime.now(), "", 0L);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota();
        //act
        FacturaMascota facturaMascotaR = servicioCobrarTiempoMascota.ejecutar(facturaMascota);
        //assert
        assertEquals(186000, (long) facturaMascotaR.getPrecioAPagar());
        assertEquals("Kaiser", facturaMascotaR.getNombreMascota());
        assertNotEquals("", facturaMascotaR.getTotalTiempoEnGuarderia());
    }

    @Test
    @DisplayName("Deberia calcular el precio de la factura con descuento premium ya que el dia es exactamente 1")
    void deberiaCalcularPrecioAPagarConDescuentoPremiumSiDiaEsUno() {
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusDays(-1);
        FacturaMascota facturaMascota = new FacturaMascota("Kaiser", fechaIngreso, LocalDateTime.now(), "", 0L);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota();
        //act
        FacturaMascota facturaMascotaR = servicioCobrarTiempoMascota.ejecutar(facturaMascota);
        //assert
        assertEquals(20400, (long) facturaMascotaR.getPrecioAPagar());
        assertEquals("Kaiser", facturaMascotaR.getNombreMascota());
        assertNotEquals("", facturaMascotaR.getTotalTiempoEnGuarderia());
    }

    @Test
    @DisplayName("Deberia calcular el precio de la factura con descuento silver ya que las horas es mayor a 12 pero menor a 1 dia")
    void deberiaCalcularPrecioAPagarConDescuentoSilverSiHorasMayorADoce() {
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusHours(-13);
        FacturaMascota facturaMascota = new FacturaMascota("Kaiser", fechaIngreso, LocalDateTime.now(), "", 0L);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota();
        //act
        FacturaMascota facturaMascotaR = servicioCobrarTiempoMascota.ejecutar(facturaMascota);
        //assert
        assertTrue(facturaMascotaR.getPrecioAPagar() < 12000);
        assertEquals(11700, facturaMascotaR.getPrecioAPagar());
        assertEquals("Kaiser", facturaMascotaR.getNombreMascota());
        assertNotEquals("", facturaMascotaR.getTotalTiempoEnGuarderia());
    }

    @Test
    @DisplayName("Deberia calcular el precio de la factura con descuento silver ya que las horas es igual a 12")
    void deberiaCalcularPrecioAPagarConDescuentoSilverSiHorasIgualADoce() {
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusHours(-12);
        FacturaMascota facturaMascota = new FacturaMascota("Kaiser", fechaIngreso, LocalDateTime.now(), "", 0L);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota();
        //act
        FacturaMascota facturaMascotaR = servicioCobrarTiempoMascota.ejecutar(facturaMascota);
        //assert
        assertTrue(facturaMascotaR.getPrecioAPagar() < 12000);
        assertEquals(10800, (long) facturaMascotaR.getPrecioAPagar());
        assertEquals("Kaiser", facturaMascotaR.getNombreMascota());
        assertNotEquals("", facturaMascotaR.getTotalTiempoEnGuarderia());
    }

    @Test
    @DisplayName("Deberia calcular el precio de la factura cuando los minutos sea mayor a 20 aplicando la minima")
    void deberiaCalcularPrecioAPagarSiMinutosMayorALaMinima() {
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusMinutes(-30);
        FacturaMascota facturaMascota = new FacturaMascota("Kaiser", fechaIngreso, LocalDateTime.now(), "", 0L);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota();
        //act
        FacturaMascota facturaMascotaR = servicioCobrarTiempoMascota.ejecutar(facturaMascota);
        //assert
        assertEquals(1000, (long) facturaMascota.getPrecioAPagar());
        assertEquals("Kaiser", facturaMascota.getNombreMascota());
        assertNotEquals("", facturaMascota.getTotalTiempoEnGuarderia());
    }

    @Test
    @DisplayName("Deberia aplicar la tarifa minima si los minutos son iguales a los esperados para que se aplique")
    void deberiaCalcularPrecioAPagarSiMinutosEsIgualALaMinima() {
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusMinutes(-20);
        FacturaMascota facturaMascota = new FacturaMascota("Kaiser", fechaIngreso, LocalDateTime.now(), "", 0L);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota();
        //act
        FacturaMascota facturaMascotaR = servicioCobrarTiempoMascota.ejecutar(facturaMascota);
        //assert
        assertEquals(1000, (long) facturaMascotaR.getPrecioAPagar());
        assertEquals("Kaiser", facturaMascotaR.getNombreMascota());
        assertNotEquals("", facturaMascotaR.getTotalTiempoEnGuarderia());
    }


    @Test
    @DisplayName("El valor de la factura deberia ser 0 ya que no supera la minima")
    void deberiaSerCeroYaQueNoSuperaLaTarifaMinima() {
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusMinutes(-10);
        FacturaMascota facturaMascota = new FacturaMascota("Kaiser", fechaIngreso, LocalDateTime.now(), "", 0L);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota();
        //act
        FacturaMascota facturaMascotaR = servicioCobrarTiempoMascota.ejecutar(facturaMascota);
        //assert
        assertEquals(0, (long) facturaMascota.getPrecioAPagar());
        assertEquals("Kaiser", facturaMascota.getNombreMascota());
        assertNotEquals("", facturaMascota.getTotalTiempoEnGuarderia());
    }

}
