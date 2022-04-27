package com.ceiba.usuario.servicio.mascota;

import com.ceiba.usuario.modelo.dto.DtoMascota;
import com.ceiba.usuario.modelo.entidad.FacturaMascota;
import com.ceiba.usuario.puerto.dao.DaoMascota;

import java.time.LocalDateTime;

import static com.ceiba.dominio.util.UtilFecha.*;

public class ServicioCobrarTiempoMascota {

    private static final int TIEMPO_MINUTOS_MINIMA = 20;
    private static final int VALOR_PESOS_POR_HORA = 1000;
    private static final int VALOR_FIJO_X_SEMANA = 138000;
    private static final int PORCENTAJE_DESCUENTO_SILVER = 10;
    private static final int PORCENTAJE_DESCUENTO_PREMIUM = 15;
    private static final int SIETE_DIAS_DE_LA_SEMANA = 7;
    private static final int CANTIDAD_HORAS_MINIMA_DESCUENTO_SILVER = 12;


    private final DaoMascota daoMascota;

    public ServicioCobrarTiempoMascota(DaoMascota daoMascota) {
        this.daoMascota = daoMascota;
    }

    public FacturaMascota ejecutar(Long idMascota) {
        DtoMascota mascota = obtenerMascota(idMascota);
        LocalDateTime fechaIngreso = mascota.getFechaIngreso();
        LocalDateTime fechaSalida = LocalDateTime.now();

        Long semanas = calcularSemanas(fechaIngreso, fechaSalida);
        Long dias =  calcularDias(fechaIngreso, fechaSalida) - semanas * SIETE_DIAS_DE_LA_SEMANA ;
        int horas = calcularHoras(fechaIngreso, fechaSalida);
        int minutos = calcularMinutos(fechaIngreso, fechaSalida);
        int totalDiasFinDeSemana = validarFinDeSemanaEntreFechas(fechaIngreso, fechaSalida);

        String totalTiempoEnGuarderia = String.format(
                "Su mascota ha estado en nuestra guarderia por: " +
                        "%s semana(s), %s dia(s), %s hora(s), %s minuto(s)",
                        semanas,dias,horas,minutos
        );

        Long totalValorSemanas = semanas * VALOR_FIJO_X_SEMANA;
        Long totalValorDias =  calcularDescuentoDias(dias);
        int totalValorHoras = calcularDescuentoHoras(horas);
        int totalMinima = calcularMinima(minutos);
        int totalHorasFinDeSemana = totalDiasFinDeSemana * 24;
        int totalValorHorasFinDeSemana = totalHorasFinDeSemana * VALOR_PESOS_POR_HORA;
        Long totalAPagar = totalValorSemanas + totalValorDias + totalValorHoras + totalMinima + totalValorHorasFinDeSemana;

        return new FacturaMascota(idMascota, mascota.getNombre(), totalTiempoEnGuarderia, totalAPagar);
    }


    private DtoMascota obtenerMascota(Long idMascota){
        return daoMascota.obtenerMascota(idMascota);
    }

    private Long calcularDescuentoDias(Long dias) {
        long dividendo = dias * 24 * VALOR_PESOS_POR_HORA;
        long divisor = 100;
        return (dividendo) - (((dividendo) * PORCENTAJE_DESCUENTO_PREMIUM) / divisor);
    }

    private int calcularDescuentoHoras(int horas){
        int totalValorHoras = 0;
        int dividendo = horas * VALOR_PESOS_POR_HORA;
        int divisor = 100;
        if(horas > CANTIDAD_HORAS_MINIMA_DESCUENTO_SILVER){
            totalValorHoras = (dividendo) - (((dividendo) * PORCENTAJE_DESCUENTO_SILVER) / divisor);
        }else{
            totalValorHoras = horas * VALOR_PESOS_POR_HORA;
        }
        return totalValorHoras;
    }

    private int calcularMinima(int minutos) {
        int totalValorMinima = 0;
        if(minutos > TIEMPO_MINUTOS_MINIMA){
            totalValorMinima = VALOR_PESOS_POR_HORA;
        }
        return totalValorMinima;
    }


}
