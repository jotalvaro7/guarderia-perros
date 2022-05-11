package com.ceiba.mascota.servicio;

import com.ceiba.usuario.modelo.dto.DtoMascota;
import com.ceiba.usuario.modelo.dto.DtoMascotaNombreFecha;
import com.ceiba.usuario.modelo.dto.DtoRegistroIngresoMascota;
import com.ceiba.usuario.modelo.entidad.FacturaMascota;
import com.ceiba.usuario.puerto.dao.DaoMascota;
import com.ceiba.usuario.puerto.dao.DaoRegistroIngresoMascota;
import com.ceiba.usuario.servicio.facturamascota.ServicioCobrarTiempoMascota;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ServicioCobrarTiempoMascotaTest {

    @Test
    @DisplayName("Deberia calcular el precio de la factura sin descuentos mayor a la minima y menor al descuento silver")
    void deberiaCalcularElPrecioDeLaFacturaSinAplicarDescuentos(){
//        //arrange
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

}
