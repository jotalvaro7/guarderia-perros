package com.ceiba.facturamascota.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.FacturaMascota;

import java.time.LocalDateTime;

public class FacturaMascotaTestDataBuilder {

    private String nombreMascota;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    private String totalTiempoEnGuarderia;
    private Long precioAPagar;

    public FacturaMascotaTestDataBuilder(){
        nombreMascota = "Zeus";
        fechaIngreso = LocalDateTime.of(2022, 04, 27, 18, 00,00);
        fechaSalida = LocalDateTime.of(2022,04,28,18,00,00);
        totalTiempoEnGuarderia = "Su mascota ha estado en nuestra guarderia por: 1 semana(s), 0 dia(s), 0 hora(s), 0 minuto(s)";
        precioAPagar = 184000L;
    }

    public FacturaMascotaTestDataBuilder conNombreMascota(String nombreMascota){
        this.nombreMascota = nombreMascota;
        return this;
    }

    public FacturaMascotaTestDataBuilder conFechaIngreso(LocalDateTime fechaIngreso){
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public FacturaMascotaTestDataBuilder conFechaSalida(LocalDateTime fechaSalida){
        this.fechaSalida = fechaSalida;
        return this;
    }

    public FacturaMascotaTestDataBuilder conPrecioAPagar(Long precioAPagar){
        this.precioAPagar = precioAPagar;
        return this;
    }

    public FacturaMascota build() {
        return new FacturaMascota(
                nombreMascota,
                fechaIngreso,
                fechaSalida,
                totalTiempoEnGuarderia,
                precioAPagar
        );
    }
}
