package com.botilleria.notificaciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {

    @Autowired(required = false)
    private KafkaNotificacionProducer kafkaNotificacionProducer;

    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        System.out.println("=========================================");
        System.out.println("Enviando Correo a: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("=========================================");
        if (kafkaNotificacionProducer != null) {
            kafkaNotificacionProducer.publicarNotificacionEnviada(destinatario, asunto, mensaje);
        }
    }
}
