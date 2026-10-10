package com.botilleria.notificaciones.consumer;

import com.botilleria.notificaciones.service.NotificacionService;
import com.botilleria.notificaciones.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class NotificacionConsumer {

    @Autowired
    private NotificacionService notificacionService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void recibirOrden(Map<String, Object> ordenData) {
        System.out.println("Evento recibido en Notificaciones: " + ordenData);
        
        String usuarioId = (String) ordenData.get("usuarioId");
        String ordenId = (String) ordenData.get("id");
        
        String mensaje = "Tu orden " + ordenId + " ha sido recibida y esta siendo procesada.";
        notificacionService.enviarCorreo(usuarioId + "@correo.com", "Confirmacion de Orden", mensaje);
    }
}
