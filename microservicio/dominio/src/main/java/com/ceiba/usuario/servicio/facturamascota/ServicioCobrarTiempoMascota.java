package com.ceiba.usuario.servicio.facturamascota;


import com.ceiba.usuario.modelo.entidad.FacturaMascota;

import java.time.LocalDateTime;

import static com.ceiba.dominio.util.UtilFecha.*;

public class ServicioCobrarTiempoMascota {

    private static final int TIEMPO_MINUTOS_MINIMA = 20;
    private static final int VALOR_PESOS_POR_HORA = 1000;
    private static final int VALOR_FIJO_X_SEMANA = 138000;
    private static final int PORCENTAJE_DESCUENTO_SILVER = 10;
    private static final int PORCENTAJE_DESCUENTO_PREMIUM = 15;
    private static final int CANTIDAD_HORAS_MINIMA_DESCUENTO_SILVER = 12;
    private static final int VEINTICUATRO_HORAS_POR_DIA = 24;
    private static final int CIEN_PORCIENTO = 100;


    public FacturaMascota ejecutar(FacturaMascota facturaMascota) {

        facturaMascota.setTotalTiempoEnGuarderia(calcularTiempoEnGuarderia(facturaMascota.getFechaIngreso()));
        facturaMascota.setPrecioAPagar(calcularValorAPagarPorTiempoEstadidaMascota(facturaMascota.getFechaIngreso()));

        return facturaMascota;
    }

    private String calcularTiempoEnGuarderia(LocalDateTime fechaIngresoMascota) {
        Long semanas = calcularSemanas(fechaIngresoMascota);
        Long dias =  calcularDiasDeLaSemana(fechaIngresoMascota);
        int horas = calcularHoras(fechaIngresoMascota);
        int minutos = calcularMinutos(fechaIngresoMascota);

        return String.format(
                "Su mascota ha estado en nuestra guarderia por: " +
                        "%s semana(s), %s dia(s), %s hora(s), %s minuto(s)",
                        semanas,dias,horas,minutos
        );
    }

    private Long calcularValorAPagarPorTiempoEstadidaMascota(LocalDateTime fechaIngresoMascota) {

        Long totalValorAPagarPorSemanas = calcularValorAPagarPorSemanas(fechaIngresoMascota);
        Long totalValorAPagarPorDias = calcularValorAPagarPorDias(fechaIngresoMascota);
        int totalValorAPagarPorHoras = calcularValorAPagarPorHoras(fechaIngresoMascota);
        int totalValorAPagarPorMinutos = calcularValorAPagarPorMinutos(fechaIngresoMascota);
        int totalValorAPagarPorFinDeSemana = calcularValorAPagarPorFinDeSemana(fechaIngresoMascota);

        return totalValorAPagarPorSemanas + totalValorAPagarPorDias + totalValorAPagarPorHoras +
                totalValorAPagarPorMinutos + totalValorAPagarPorFinDeSemana;
    }


    private Long calcularValorAPagarPorSemanas(LocalDateTime fechaIngresoMascota) {
        Long semanas = calcularSemanas(fechaIngresoMascota);
        return semanas * VALOR_FIJO_X_SEMANA;
    }

    private Long calcularValorAPagarPorDias(LocalDateTime fechaIngresoMascota) {
        Long dias =  calcularDiasDeLaSemana(fechaIngresoMascota);
        return calcularDescuentoDias(dias);
    }

    private int calcularValorAPagarPorHoras(LocalDateTime fechaIngresoMascota) {
        int horas = calcularHoras(fechaIngresoMascota);
        return calcularDescuentoHoras(horas);
    }

    private int calcularValorAPagarPorMinutos(LocalDateTime fechaIngresoMascota) {
        int minutos = calcularMinutos(fechaIngresoMascota);
        return calcularMinima(minutos);
    }

    private int calcularValorAPagarPorFinDeSemana(LocalDateTime fechaIngresoMascota) {
        int totalDiasFinDeSemana = validarFinDeSemanaEntreFechas(fechaIngresoMascota);
        int totalHorasFinDeSemana = totalDiasFinDeSemana * VEINTICUATRO_HORAS_POR_DIA;
        return totalHorasFinDeSemana * VALOR_PESOS_POR_HORA;
    }


    private Long calcularDescuentoDias(Long dias) {
        long dividendo = dias * VEINTICUATRO_HORAS_POR_DIA * VALOR_PESOS_POR_HORA;
        return (dividendo) - (((dividendo) * PORCENTAJE_DESCUENTO_PREMIUM) / CIEN_PORCIENTO);
    }

    private int calcularDescuentoHoras(int horas){
        int totalValorHoras = 0;
        int dividendo = horas * VALOR_PESOS_POR_HORA;
        if(horas >= CANTIDAD_HORAS_MINIMA_DESCUENTO_SILVER){
            totalValorHoras = (dividendo) - (((dividendo) * PORCENTAJE_DESCUENTO_SILVER) / CIEN_PORCIENTO);
        }else{
            totalValorHoras = horas * VALOR_PESOS_POR_HORA;
        }
        return totalValorHoras;
    }

    private int calcularMinima(int minutos) {
        int totalValorMinima = 0;
        if(minutos >= TIEMPO_MINUTOS_MINIMA){
            totalValorMinima = VALOR_PESOS_POR_HORA;
        }
        return totalValorMinima;
    }


}
