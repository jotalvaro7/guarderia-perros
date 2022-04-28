package com.ceiba.dominio.util;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UtilFecha {

    private static final int SIETE_DIAS_DE_LA_SEMANA = 7;

    public static Long calcularSemanas(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        return ChronoUnit.WEEKS.between(fechaIngreso, fechaSalida);
    }

    public static Long calcularDiasDeLaSemana(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        Duration duration = Duration.between(fechaIngreso, fechaSalida);
        long dias = duration.toDaysPart();
        long semanas = calcularSemanas(fechaIngreso, fechaSalida);
        return dias - semanas * SIETE_DIAS_DE_LA_SEMANA;
    }

    public static Long calcularDiasNetos(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        Duration duration = Duration.between(fechaIngreso, fechaSalida);
        return duration.toDaysPart();
    }

    public static Integer calcularHoras(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        Duration duration = Duration.between(fechaIngreso, fechaSalida);
        return duration.toHoursPart();
    }

    public static Integer calcularMinutos(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        Duration duration = Duration.between(fechaIngreso, fechaSalida);
        return duration.toMinutesPart();
    }

    public static Integer validarFinDeSemanaEntreFechas(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {

        Long diferenciaDeDias = calcularDiasNetos(fechaInicial , fechaFinal);

        int totalDiasFinDeSemana = 0;
        fechaInicial = fechaInicial.plusDays(-1);
        for (int i = 1; i <= diferenciaDeDias; i++) {
            LocalDateTime fecha = fechaInicial.plusDays(i);
            if (fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
                totalDiasFinDeSemana += 1;
            }
        }
        return totalDiasFinDeSemana;
    }
}
