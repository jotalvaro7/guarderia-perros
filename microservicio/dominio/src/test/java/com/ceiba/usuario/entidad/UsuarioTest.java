package com.ceiba.usuario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.usuario.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {

    @Test
    @DisplayName("Deberia crear correctamente el usuario")
    void deberiaCrearCorrectamenteElUsusuario() {
        //arrange
        Usuario usuario = new UsuarioTestDataBuilder()
                .conNombre("Diego")
                .conApellido("Lopez")
                .conIdentificacion("10369443")
                .conNumeroCelular("789456")
                .conId(1L).build();
        //
        assertEquals(1, usuario.getId());
        assertEquals("Diego", usuario.getNombre());
        assertEquals("Lopez", usuario.getApellido());
        assertEquals("10369443", usuario.getIdentificacion());
        assertEquals("789456", usuario.getNumeroCelular());
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el nombre del usuario es vacio")
    void deberiaLanzarUnaExepcionCuandoElNombreDeUsuarioEsVacio() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conNombre("");
        // act - assert
        BasePrueba.assertThrows(usuarioTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de usuario");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el nombre del usuario es null")
    void deberiaLanzarUnaExepcionCuandoElNombreDeUsuarioEsNull() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conNombre(null);
        // act - assert
        BasePrueba.assertThrows(usuarioTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de usuario");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el apellido del usuario es vacio")
    void deberiaLanzarUnaExepcionCuandoElApellidoDeUsuarioEsVacio() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conApellido("");
        // act - assert
        BasePrueba.assertThrows(usuarioTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el apellido de usuario");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el apellido del usuario es null")
    void deberiaLanzarUnaExepcionCuandoElApellidoDeUsuarioEsNull() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conApellido(null);
        // act - assert
        BasePrueba.assertThrows(usuarioTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el apellido de usuario");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando la identificacion del usuario es vacio")
    void deberiaLanzarUnaExepcionCuandoLaIdentificacionDeUsuarioEsVacio() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conIdentificacion("");
        // act - assert
        BasePrueba.assertThrows(usuarioTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la identificacion de usuario");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando la identificacion del usuario es null")
    void deberiaLanzarUnaExepcionCuandoLaIdentificacionDeUsuarioEsNull() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conIdentificacion(null);
        // act - assert
        BasePrueba.assertThrows(usuarioTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la identificacion de usuario");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando la identificacion del usuario es vacio")
    void deberiaLanzarUnaExepcionCuandoElNumeroCelularDeUsuarioEsVacio() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conNumeroCelular("");
        // act - assert
        BasePrueba.assertThrows(usuarioTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el numero de celular de usuario");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando la identificacion del usuario es null")
    void deberiaLanzarUnaExepcionCuandoElNumeroCelularDeUsuarioEsNull() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conNumeroCelular(null);
        // act - assert
        BasePrueba.assertThrows(usuarioTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar el numero de celular de usuario");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Usuario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelUsuario() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }



}
