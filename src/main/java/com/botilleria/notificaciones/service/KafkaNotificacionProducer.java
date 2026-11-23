package com.botilleria.notificaciones.service;

import com.botilleria.notificaciones.dto.NotificacionEventoKafkaDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class KafkaNotificacionProducer {

    @Autowired(required = false)
    private KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${app.kafka.enabled:true}")
    private boolean kafkaEnabled;

    @Value("${app.kafka.topic-notificaciones:notificaciones.eventos}")
    private String topicNotificaciones;

    public void publicarNotificacionEnviada(String destinatario, String asunto, String mensaje) {
        if (!kafkaEnabled || kafkaTemplate == null) {
            return;
        }
        try {
            NotificacionEventoKafkaDto dto = new NotificacionEventoKafkaDto();
            dto.setTipoEvento("NOTIFICACION_ENVIADA");
            dto.setOrigen("ms-notificaciones");
            dto.setDestinatario(destinatario);
            dto.setAsunto(asunto);
            dto.setMensaje(mensaje);
            dto.setTimestamp(Instant.now().toString());

            kafkaTemplate.send(topicNotificaciones, destinatario != null ? destinatario : "sistema", objectMapper.writeValueAsString(dto));
        } catch (Exception e) {
            System.err.println("[ms-notificaciones] Aviso Kafka (no bloqueante): " + e.getMessage());
        }
    }
}
