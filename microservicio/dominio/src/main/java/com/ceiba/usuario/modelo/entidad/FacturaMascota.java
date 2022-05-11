package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class FacturaMascota {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_MASCOTA = "Se debe ingresar el nombre de la mascota";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO = "Se debe ingresar la fecha de ingreso de la mascota";
    private static final String SE_DEBE_INGRESAR_EL_FECHA_DE_SALIDA = "Se debe ingresar la fecha de salida de la mascota";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_A_PAGAR = "Se debe ingresar el precio a pagar";

    private String nombreMascota;
    private LocalDateTime fechaIngreso;
    private  LocalDateTime fechaSalida;
    private String totalTiempoEnGuarderia;
    private Long precioAPagar;

    public FacturaMascota(String nombreMascota, LocalDateTime fechaIngreso, LocalDateTime fechaSalida,
                          String totalTiempoEnGuarderia, Long precioAPagar) {

        validarObligatorio(nombreMascota, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_MASCOTA);
        validarObligatorio(fechaIngreso, SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO);
        validarObligatorio(fechaSalida, SE_DEBE_INGRESAR_EL_FECHA_DE_SALIDA);
        validarObligatorio(precioAPagar, SE_DEBE_INGRESAR_EL_PRECIO_A_PAGAR);

        this.nombreMascota = nombreMascota;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.totalTiempoEnGuarderia = totalTiempoEnGuarderia;
        this.precioAPagar = precioAPagar;
    }
}
