package com.botilleria.notificaciones.controller;

import com.botilleria.notificaciones.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @PostMapping("/test")
    public ResponseEntity<String> probarCorreo(@RequestBody Map<String, String> payload) {
        String destinatario = payload.getOrDefault("destinatario", "prueba@correo.com");
        String asunto = payload.getOrDefault("asunto", "Prueba desde Postman");
        String mensaje = payload.getOrDefault("mensaje", "Este es un mensaje de prueba.");
        
        notificacionService.enviarCorreo(destinatario, asunto, mensaje);
        return ResponseEntity.ok("Correo simulado enviado exitosamente a " + destinatario);
    }
}
