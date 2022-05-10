package com.ceiba.dominio.util;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UtilFecha {

    private static final int SIETE_DIAS_DE_LA_SEMANA = 7;
    private static final LocalDateTime DIA_ACTUAL = LocalDateTime.now();

    public static Long calcularSemanas(LocalDateTime fechaIngreso) {
        return ChronoUnit.WEEKS.between(fechaIngreso, DIA_ACTUAL);
    }

    public static Long calcularDiasDeLaSemana(LocalDateTime fechaIngreso) {
        Duration duration = Duration.between(fechaIngreso, DIA_ACTUAL);
        long dias = duration.toDaysPart();
        long semanas = calcularSemanas(fechaIngreso);
        return dias - semanas * SIETE_DIAS_DE_LA_SEMANA;
    }

    public static Long calcularDiasNetos(LocalDateTime fechaIngreso) {
        Duration duration = Duration.between(fechaIngreso, DIA_ACTUAL);
        return duration.toDaysPart();
    }

    public static Integer calcularHoras(LocalDateTime fechaIngreso) {
        Duration duration = Duration.between(fechaIngreso, DIA_ACTUAL);
        return duration.toHoursPart();
    }

    public static Integer calcularMinutos(LocalDateTime fechaIngreso) {
        Duration duration = Duration.between(fechaIngreso, DIA_ACTUAL);
        return duration.toMinutesPart();
    }

    public static Integer validarFinDeSemanaEntreFechas(LocalDateTime fechaInicial) {

        Long diferenciaDeDias = calcularDiasNetos(fechaInicial);

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
