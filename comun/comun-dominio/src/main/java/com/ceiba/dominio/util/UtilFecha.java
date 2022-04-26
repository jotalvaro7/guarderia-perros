package com.ceiba.dominio.util;

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
}
