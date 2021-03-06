package com.ceiba.configuracion.beanregistroingresomascota;

import com.ceiba.usuario.puerto.repositorio.RepositorioMascota;
import com.ceiba.usuario.puerto.repositorio.RepositorioRegistroIngresoMascota;
import com.ceiba.usuario.servicio.mascota.ServicioCrearMascota;
import com.ceiba.usuario.servicio.registroingresomascota.ServicioCrearRegistroIngresoMascota;
import com.ceiba.usuario.servicio.registroingresomascota.ServicioEliminarRegistroIngresoMascota;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanRegistroIngresoMascota {

    @Bean
    public ServicioCrearRegistroIngresoMascota servicioCrearRegistroIngresoMascota(RepositorioRegistroIngresoMascota repositorioRegistroIngresoMascota) {
        return new ServicioCrearRegistroIngresoMascota(repositorioRegistroIngresoMascota);
    }

    @Bean
    public ServicioEliminarRegistroIngresoMascota servicioEliminarRegistroIngresoMascota(RepositorioRegistroIngresoMascota repositorioRegistroIngresoMascota) {
        return new ServicioEliminarRegistroIngresoMascota(repositorioRegistroIngresoMascota);
    }
}
