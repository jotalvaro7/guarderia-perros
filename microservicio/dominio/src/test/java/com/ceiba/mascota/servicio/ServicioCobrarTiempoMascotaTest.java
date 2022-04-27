package com.ceiba.mascota.servicio;

import com.ceiba.usuario.modelo.dto.DtoMascota;
import com.ceiba.usuario.modelo.entidad.FacturaMascota;
import com.ceiba.usuario.puerto.dao.DaoMascota;
import com.ceiba.usuario.servicio.mascota.ServicioCobrarTiempoMascota;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ServicioCobrarTiempoMascotaTest {

    @Test
    @DisplayName("Deberia calcular el precio de la factura sin descuentos mayor a la minima y menor al descuento silver")
    void deberiaCalcularElPrecioDeLaFacturaSinAplicarDescuentos(){
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusHours(-5);
        DtoMascota mascota = new DtoMascota(1L, "Can", "Pastor Aleman", "20Kg", fechaIngreso, 1L);
        DaoMascota daoMascota = Mockito.mock(DaoMascota.class);
        Mockito.when(daoMascota.obtenerMascota(Mockito.anyLong())).thenReturn(mascota);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota(daoMascota);
        //act
        FacturaMascota facturaMascota = servicioCobrarTiempoMascota.ejecutar(1L);
        //assert
        assertEquals(5000, (long) facturaMascota.getPrecioAPagar());
        assertEquals("Can", facturaMascota.getNombreMascota());
        assertNotEquals("", facturaMascota.getTotalTiempoEnGuarderia());
    }

    @Test
    @DisplayName("Deberia calcular el precio fijo si el tiempo es 1 semana exactamente")
    void deberiaCalcularPrecioAPagarConPrecioFijoSiSemanaEs1() {
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusWeeks(-1);
        DtoMascota mascota = new DtoMascota(1L, "Can", "Pastor Aleman", "20Kg", fechaIngreso, 1L);
        DaoMascota daoMascota = Mockito.mock(DaoMascota.class);
        Mockito.when(daoMascota.obtenerMascota(Mockito.anyLong())).thenReturn(mascota);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota(daoMascota);
        //act
        FacturaMascota facturaMascota = servicioCobrarTiempoMascota.ejecutar(1L);
        //assert
        assertEquals(186000, (long) facturaMascota.getPrecioAPagar());
        assertEquals("Can", facturaMascota.getNombreMascota());
        assertNotEquals("", facturaMascota.getTotalTiempoEnGuarderia());
    }

    @Test
    @DisplayName("Deberia calcular el precio de la factura con descuento premium ya que el dia es exactamente 1")
    void deberiaCalcularPrecioAPagarConDescuentoPremiumSiDiaEsUno() {
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusDays(-1);
        DtoMascota mascota = new DtoMascota(1L, "Can", "Pastor Aleman", "20Kg", fechaIngreso, 1L);
        DaoMascota daoMascota = Mockito.mock(DaoMascota.class);
        Mockito.when(daoMascota.obtenerMascota(Mockito.anyLong())).thenReturn(mascota);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota(daoMascota);
        //act
        FacturaMascota facturaMascota = servicioCobrarTiempoMascota.ejecutar(1L);
        //assert
        assertEquals(20400, (long) facturaMascota.getPrecioAPagar());
        assertEquals("Can", facturaMascota.getNombreMascota());
        assertNotEquals("", facturaMascota.getTotalTiempoEnGuarderia());
    }

    @Test
    @DisplayName("Deberia calcular el precio de la factura con descuento silver ya que las horas es mayor a 12 pero menor a 1 dia")
    void deberiaCalcularPrecioAPagarConDescuentoSilverSiHorasMayorADoce() {
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusHours(-13);
        DtoMascota mascota = new DtoMascota(1L, "Can", "Pastor Aleman", "20Kg", fechaIngreso, 1L);
        DaoMascota daoMascota = Mockito.mock(DaoMascota.class);
        Mockito.when(daoMascota.obtenerMascota(Mockito.anyLong())).thenReturn(mascota);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota(daoMascota);
        //act
        FacturaMascota facturaMascota = servicioCobrarTiempoMascota.ejecutar(1L);
        //assert
        assertTrue(facturaMascota.getPrecioAPagar() < 12000);
        assertEquals("Can", facturaMascota.getNombreMascota());
        assertNotEquals("", facturaMascota.getTotalTiempoEnGuarderia());
    }

    @Test
    @DisplayName("Deberia calcular el precio de la factura cuando los minutos sea mayor a 20 aplicando la minima")
    void deberiaCalcularPrecioAPagarSiMinutosMayorALaMinima() {
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusMinutes(-30);
        DtoMascota mascota = new DtoMascota(1L, "Can", "Pastor Aleman", "20Kg", fechaIngreso, 1L);
        DaoMascota daoMascota = Mockito.mock(DaoMascota.class);
        Mockito.when(daoMascota.obtenerMascota(Mockito.anyLong())).thenReturn(mascota);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota(daoMascota);
        //act
        FacturaMascota facturaMascota = servicioCobrarTiempoMascota.ejecutar(1L);
        //assert
        assertEquals(1000, (long) facturaMascota.getPrecioAPagar());
        assertEquals("Can", facturaMascota.getNombreMascota());
        assertNotEquals("", facturaMascota.getTotalTiempoEnGuarderia());
    }

    @Test
    @DisplayName("El valor de la factura deberia ser 0 ya que no supera la minima")
    void deberiaSerCeroYaQueNoSuperaLaTarifaMinima() {
        //arrange
        LocalDateTime fechaIngreso = LocalDateTime.now().plusMinutes(-10);
        DtoMascota mascota = new DtoMascota(1L, "Can", "Pastor Aleman", "20Kg", fechaIngreso, 1L);
        DaoMascota daoMascota = Mockito.mock(DaoMascota.class);
        Mockito.when(daoMascota.obtenerMascota(Mockito.anyLong())).thenReturn(mascota);
        ServicioCobrarTiempoMascota servicioCobrarTiempoMascota = new ServicioCobrarTiempoMascota(daoMascota);
        //act
        FacturaMascota facturaMascota = servicioCobrarTiempoMascota.ejecutar(1L);
        //assert
        assertEquals(0, (long) facturaMascota.getPrecioAPagar());
        assertEquals("Can", facturaMascota.getNombreMascota());
        assertNotEquals("", facturaMascota.getTotalTiempoEnGuarderia());
    }


}
