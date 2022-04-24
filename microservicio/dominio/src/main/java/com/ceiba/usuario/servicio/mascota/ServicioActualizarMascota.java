package com.ceiba.usuario.servicio.mascota;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Mascota;
import com.ceiba.usuario.puerto.repositorio.RepositorioMascota;

public class ServicioActualizarMascota {

    private static final String LA_MASCOTA_NO_EXISTE_EN_EL_SISTEMA = "La mascota no existe en el sistema";

    private final RepositorioMascota repositorioMascota;

    public ServicioActualizarMascota(RepositorioMascota repositorioMascota) {
        this.repositorioMascota = repositorioMascota;
    }

    public void ejecutar(Mascota mascota){
        validadExistenciaPrevia(mascota);
        this.repositorioMascota.actualizar(mascota);
    }

    private void validadExistenciaPrevia(Mascota mascota) {
        boolean existe = this.repositorioMascota.existePorId(mascota.getId());
        if(!existe){
            throw new ExcepcionDuplicidad(LA_MASCOTA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
