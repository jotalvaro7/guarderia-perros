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

        facturaMascota.setTotalTiempoEnGuarderia(calcularTiempoEnGuarderia(facturaMascota.getFechaIngreso(), facturaMascota.getFechaSalida()));
        facturaMascota.setPrecioAPagar(calcularValorAPagarPorTiempoEstadidaMascota(facturaMascota.getFechaIngreso(), facturaMascota.getFechaSalida()));

        return facturaMascota;
    }

    private String calcularTiempoEnGuarderia(LocalDateTime fechaIngresoMascota, LocalDateTime fechaSalidaMascota) {
        Long semanas = calcularSemanas(fechaIngresoMascota, fechaSalidaMascota);
        Long dias =  calcularDiasDeLaSemana(fechaIngresoMascota, fechaSalidaMascota);
        int horas = calcularHoras(fechaIngresoMascota, fechaSalidaMascota);
        int minutos = calcularMinutos(fechaIngresoMascota, fechaSalidaMascota);

        return String.format(
                "Su mascota ha estado en nuestra guarderia por: " +
                        "%s semana(s), %s dia(s), %s hora(s), %s minuto(s)",
                        semanas,dias,horas,minutos
        );
    }

    private Long calcularValorAPagarPorTiempoEstadidaMascota(LocalDateTime fechaIngresoMascota, LocalDateTime fechaSalidaMascota) {

        Long totalValorAPagarPorSemanas = calcularValorAPagarPorSemanas(fechaIngresoMascota, fechaSalidaMascota);
        Long totalValorAPagarPorDias = calcularValorAPagarPorDias(fechaIngresoMascota, fechaSalidaMascota);
        int totalValorAPagarPorHoras = calcularValorAPagarPorHoras(fechaIngresoMascota, fechaSalidaMascota);
        int totalValorAPagarPorMinutos = calcularValorAPagarPorMinutos(fechaIngresoMascota, fechaSalidaMascota);
        int totalValorAPagarPorFinDeSemana = calcularValorAPagarPorFinDeSemana(fechaIngresoMascota, fechaSalidaMascota);

        return totalValorAPagarPorSemanas + totalValorAPagarPorDias + totalValorAPagarPorHoras +
                totalValorAPagarPorMinutos + totalValorAPagarPorFinDeSemana;
    }


    private Long calcularValorAPagarPorSemanas(LocalDateTime fechaIngresoMascota, LocalDateTime fechaSalidaMascota) {
        Long semanas = calcularSemanas(fechaIngresoMascota, fechaSalidaMascota);
        return semanas * VALOR_FIJO_X_SEMANA;
    }

    private Long calcularValorAPagarPorDias(LocalDateTime fechaIngresoMascota, LocalDateTime fechaSalidaMascota) {
        Long dias =  calcularDiasDeLaSemana(fechaIngresoMascota, fechaSalidaMascota);
        return calcularDescuentoDias(dias);
    }

    private int calcularValorAPagarPorHoras(LocalDateTime fechaIngresoMascota, LocalDateTime fechaSalidaMascota) {
        int horas = calcularHoras(fechaIngresoMascota, fechaSalidaMascota);
        return calcularDescuentoHoras(horas);
    }

    private int calcularValorAPagarPorMinutos(LocalDateTime fechaIngresoMascota, LocalDateTime fechaSalidaMascota) {
        int minutos = calcularMinutos(fechaIngresoMascota, fechaSalidaMascota);
        return calcularMinima(minutos);
    }

    private int calcularValorAPagarPorFinDeSemana(LocalDateTime fechaIngresoMascota, LocalDateTime fechaSalidaMascota) {
        int totalDiasFinDeSemana = validarFinDeSemanaEntreFechas(fechaIngresoMascota, fechaSalidaMascota);
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
