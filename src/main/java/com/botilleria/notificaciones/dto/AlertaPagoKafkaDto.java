package com.botilleria.notificaciones.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertaPagoKafkaDto {
    private String tipoEvento;
    private String ordenId;
    private String usuarioId;
    private Integer monto;
    private String tarjetaEnmascarada;
    private String estado;
    private String mensajeAlerta;
    private String timestamp;

    public String getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }

    public String getOrdenId() { return ordenId; }
    public void setOrdenId(String ordenId) { this.ordenId = ordenId; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public Integer getMonto() { return monto; }
    public void setMonto(Integer monto) { this.monto = monto; }

    public String getTarjetaEnmascarada() { return tarjetaEnmascarada; }
    public void setTarjetaEnmascarada(String tarjetaEnmascarada) { this.tarjetaEnmascarada = tarjetaEnmascarada; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getMensajeAlerta() { return mensajeAlerta; }
    public void setMensajeAlerta(String mensajeAlerta) { this.mensajeAlerta = mensajeAlerta; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
