package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FacturaMascota {
    private Long idFactura;
    private String nombreMascota;
    private LocalDateTime fechaIngreso;
    private  LocalDateTime fechaSalida;
    private String totalTiempoEnGuarderia;
    private Long precioAPagar;

    public FacturaMascota(Long idFactura, String nombreMascota, LocalDateTime fechaIngreso,
                          LocalDateTime fechaSalida, String totalTiempoEnGuarderia, Long precioAPagar) {

        //AGREGAR VALIDACIONES

        this.idFactura = idFactura;
        this.nombreMascota = nombreMascota;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.totalTiempoEnGuarderia = totalTiempoEnGuarderia;
        this.precioAPagar = precioAPagar;
    }
}
