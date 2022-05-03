package com.ceiba.usuario.controlador.usuario;

import java.util.List;

import com.ceiba.usuario.consulta.usuario.ManejadorListarUsuarios;
import com.ceiba.usuario.consulta.usuario.ManejadorObtenerUsuario;
import org.springframework.web.bind.annotation.*;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/usuarios")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorUsuario {

    private final ManejadorListarUsuarios manejadorListarUsuarios;
    private final ManejadorObtenerUsuario manejadorObtenerUsuario;

    public ConsultaControladorUsuario(ManejadorListarUsuarios manejadorListarUsuarios, ManejadorObtenerUsuario manejadorObtenerUsuario) {
        this.manejadorListarUsuarios = manejadorListarUsuarios;
        this.manejadorObtenerUsuario = manejadorObtenerUsuario;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoUsuario> listar() {
        return this.manejadorListarUsuarios.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("Listar Usuario por Id")
    public DtoUsuario listarPorId(@PathVariable Long id){
        return this.manejadorObtenerUsuario.obtener(id);
    }

}
