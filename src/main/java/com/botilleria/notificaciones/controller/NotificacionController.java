package com.botilleria.notificaciones.controller;


import com.botilleria.notificaciones.model.Notificacion;
import com.botilleria.notificaciones.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService servicioDeNotificacion;

    @GetMapping
    public ResponseEntity<List<Notificacion>> listarCatalogo() {
        return ResponseEntity.ok(servicioDeNotificacion.obtenerTodos());
    }

    @GetMapping("/{identificador}")
    public ResponseEntity<Notificacion> obtenerDetalle(@PathVariable Long identificador) {
        Notificacion notificacionEncontrado = servicioDeNotificacion.buscarPorId(identificador);
        if (notificacionEncontrado != null) {
            return ResponseEntity.ok(notificacionEncontrado);
        }
        return ResponseEntity.notFound().build();
    }
}