package com.botilleria.notificaciones.service;

import org.springframework.stereotype.Service;

@Service
public class NotificacionService {

    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        // Aca se simula el envio o se integra JavaMailSender
        System.out.println("=========================================");
        System.out.println("Enviando Correo a: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("=========================================");
    }
}
