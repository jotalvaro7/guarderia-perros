package com.ceiba.configuracion.beanMascota;

import com.ceiba.usuario.puerto.repositorio.RepositorioMascota;
import com.ceiba.usuario.servicio.mascota.ServicioActualizarMascota;
import com.ceiba.usuario.servicio.mascota.ServicioCrearMascota;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanMascota {

    @Bean
    public ServicioCrearMascota servicioCrearMascota(RepositorioMascota repositorioMascota) {
        return new ServicioCrearMascota(repositorioMascota);
    }
    @Bean
    public ServicioActualizarMascota servicioActualizarMascota(RepositorioMascota repositorioMascota) {
        return new ServicioActualizarMascota(repositorioMascota);
    }
}
