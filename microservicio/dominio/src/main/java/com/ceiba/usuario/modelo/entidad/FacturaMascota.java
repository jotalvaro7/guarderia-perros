package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

@Getter
public class FacturaMascota {
    private Long idMascota;
    private String nombreMascota;
    private String totalTiempoEnGuarderia;
    private Long precioAPagar;

    public FacturaMascota(Long idMascota, String nombreMascota, String totalTiempoEnGuarderia, Long precioAPagar) {
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.totalTiempoEnGuarderia = totalTiempoEnGuarderia;
        this.precioAPagar = precioAPagar;
    }
}
