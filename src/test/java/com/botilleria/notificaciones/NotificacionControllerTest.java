package com.botilleria.notificaciones;

import com.botilleria.notificaciones.controller.NotificacionController;
import com.botilleria.notificaciones.controller.NotificacionController;
import com.botilleria.notificaciones.model.Notificacion;
import com.botilleria.notificaciones.service.NotificacionService;
import com.botilleria.notificaciones.service.NotificacionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(NotificacionController.class)
public class NotificacionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotificacionService servicioDeNotificacion;

    @Test
    public void listarCatalogo_DeberiaRetornarListaDeNotificaciones() throws Exception {
        Notificacion p1 = new Notificacion(1L, "Pisco Alto del Carmen 35°", 7500, 20, "https://via.placeholder.com/200");
        Mockito.when(servicioDeNotificacion.obtenerTodos()).thenReturn(List.of(p1));

        mockMvc.perform(get("/api/notificaciones"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Pisco Alto del Carmen 35°"));
    }
}