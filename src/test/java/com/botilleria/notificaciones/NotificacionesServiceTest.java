package com.botilleria.notificaciones;

import com.botilleria.notificaciones.model.Notificacion;
import com.botilleria.notificaciones.service.NotificacionService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NotificacionesServiceTest {

    @Test
    public void alObtenerTodos_deberiaRetornarTresNotificaciones() {
        NotificacionService servicio = new NotificacionService();
        List<Notificacion> lista = servicio.obtenerTodos();

        assertNotNull(lista);
        assertEquals(3, lista.size());
    }

    @Test
    public void alBuscarPorId_deberiaRetornarElNotificacionCorrecto() {
        NotificacionService servicio = new NotificacionService();
        Notificacion notificacion = servicio.buscarPorId(1L);

        assertNotNull(notificacion);
        assertEquals("Pisco Alto del Carmen 35°", notificacion.getNombre());
    }
}