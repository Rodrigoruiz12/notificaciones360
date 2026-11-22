package com.botilleria.notificaciones.consumer;

import com.botilleria.notificaciones.dto.AlertaPagoKafkaDto;
import com.botilleria.notificaciones.service.NotificacionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Consumidor Kafka en ms-notificaciones: envia alertas de seguridad por correo cuando
 * ms-pagos detecta un intento fraudulento en pagos.alertas, manteniendo RabbitMQ intacto.
 */
@Component
public class NotificacionKafkaConsumer {

    private final NotificacionService notificacionService;
    private final ObjectMapper objectMapper;

    public NotificacionKafkaConsumer(NotificacionService notificacionService, ObjectMapper objectMapper) {
        this.notificacionService = notificacionService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(
            topics = "${app.kafka.topic-pagos:pagos.alertas}",
            groupId = "${spring.kafka.consumer.group-id:ms-notificaciones-group}",
            autoStartup = "${app.kafka.enabled:true}"
    )
    public void consumirAlertaPago(String payload) {
        AlertaPagoKafkaDto evento;
        try {
            evento = objectMapper.readValue(payload, AlertaPagoKafkaDto.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Payload no es JSON valido en pagos.alertas", e);
        }

        String usuario = (evento.getUsuarioId() != null && !evento.getUsuarioId().isBlank())
                ? evento.getUsuarioId()
                : "cliente";
        String destinatario = usuario.contains("@") ? usuario : usuario + "@correo.com";

        if ("FRAUDE_BLOQUEADO".equalsIgnoreCase(evento.getTipoEvento())) {
            String cuerpo = evento.getMensajeAlerta() != null
                    ? evento.getMensajeAlerta()
                    : "Se bloqueo un intento de pago sospechoso con la tarjeta " + evento.getTarjetaEnmascarada();
            notificacionService.enviarCorreo(destinatario, "ALERTA DE SEGURIDAD - Pago Bloqueado", cuerpo);
        } else {
            System.out.println("[MS-NOTIFICACIONES][KAFKA] Evento pago procesado: " + evento.getTipoEvento()
                    + " | orden=" + evento.getOrdenId());
        }
    }
}
