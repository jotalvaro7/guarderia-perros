package com.ceiba.mascota.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.usuario.controlador.mascota.ConsultaControladorMascota;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorMascota.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorMascotaTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deberiaListarLasMascotasDeUsuario() throws Exception {
        //arrange
        Long id = 1L;
        //act - asse
        mockMvc.perform(get("/mascotas/usuario/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre", is("Max")))
                .andExpect(jsonPath("$[0].raza", is("Pastor Aleman")))
                .andExpect(jsonPath("$[0].peso", is("10Kg")))
                .andExpect(jsonPath("$[0].idUsuario", is(1)));
    }

    @Test
    @DisplayName("Deberia obtener una mascota")
    void deberiaObtenerMascota() throws Exception {
        //arrange
        Long id = 1L;
        //act-asse
        mockMvc.perform(get("/mascotas/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Max")))
                .andExpect(jsonPath("$.raza", is("Pastor Aleman")))
                .andExpect(jsonPath("$.peso", is("10Kg")))
                .andExpect(jsonPath("$.idUsuario", is(1)));
    }
}
