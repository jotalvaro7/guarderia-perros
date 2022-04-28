package com.ceiba.registroingresomascota.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.registroingresomascota.servicio.testdatabuilder.ComandoRegistroIngresoMascotaTestDataBuilder;
import com.ceiba.usuario.comando.ComandoRegistroIngresoMascota;
import com.ceiba.usuario.controlador.mascota.ConsultaControladorMascota;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorMascota.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorRegistroIngresoMascotaTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Deberia Crear Registro Ingreso Mascota")
    void deberiaCrearRegistroIngresoMascota() throws Exception {

        ComandoRegistroIngresoMascota registroIngresoMascota = new ComandoRegistroIngresoMascotaTestDataBuilder().build();

        mockMvc.perform(post("/registro/ingreso")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registroIngresoMascota)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 4}"));
    }
}
