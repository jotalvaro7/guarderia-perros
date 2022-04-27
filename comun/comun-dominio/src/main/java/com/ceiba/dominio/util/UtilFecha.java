package com.ceiba.dominio.util;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UtilFecha {


    public static Long calcularSemanas(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        return ChronoUnit.WEEKS.between(fechaIngreso, fechaSalida);
    }

    public static Long calcularDias(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
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

        Long diferenciaDeDias = calcularDias(fechaInicial , fechaFinal);

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
