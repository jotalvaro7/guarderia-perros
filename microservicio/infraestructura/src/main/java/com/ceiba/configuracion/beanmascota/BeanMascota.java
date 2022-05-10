package com.ceiba.configuracion.beanmascota;

import com.ceiba.usuario.modelo.entidad.FacturaMascota;
import com.ceiba.usuario.puerto.dao.DaoMascota;
import com.ceiba.usuario.puerto.dao.DaoRegistroIngresoMascota;
import com.ceiba.usuario.puerto.repositorio.RepositorioMascota;
import com.ceiba.usuario.servicio.mascota.ServicioActualizarMascota;
import com.ceiba.usuario.servicio.facturamascota.ServicioCobrarTiempoMascota;
import com.ceiba.usuario.servicio.mascota.ServicioCrearMascota;
import com.ceiba.usuario.servicio.mascota.ServicioEliminarMascota;
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

    @Bean
    public ServicioEliminarMascota servicioEliminarMascota(RepositorioMascota repositorioMascota) {
        return new ServicioEliminarMascota(repositorioMascota);
    }

    @Bean
    public ServicioCobrarTiempoMascota servicioCobrarTiempoMascota(){
        return new ServicioCobrarTiempoMascota();
    }
}
