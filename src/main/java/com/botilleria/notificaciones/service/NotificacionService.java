package com.botilleria.notificaciones.service;

import com.botilleria.notificaciones.model.Notificacion;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificacionService {
    private List<Notificacion> listaDeNotificaciones = new ArrayList<>();

    public NotificacionService() {
        // Precios actualizados a la realidad chilena
        listaDeNotificaciones.add(new Notificacion(1L, "Pisco Alto del Carmen 35°", 7500, 20, "https://d3w3u0f6pasxxu.cloudfront.net/optimized/12e266cbd209e421a915bf9ad1ca524e-3x.jpeg"));
        listaDeNotificaciones.add(new Notificacion(2L, "Cerveza Escudo Lata 470cc", 1500, 150, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeWk8thFq5OCe_VfDfQ8_ZGLxEFqbEF9GoocXrEqeLww-p_E-Nz4ccn8my&s=10"));
        listaDeNotificaciones.add(new Notificacion(3L, "Vino Casillero del Diablo", 6500, 35, "https://conchaytoro.com/wp-content/uploads/2018/07/7X1A7469-editada-min.webp"));
        listaDeNotificaciones.add(new Notificacion(4L, "Whisky Johnnie Walker Red Label", 18000, 15, "https://santaisabel.vtexassets.com/arquivos/ids/377375/Whisky-Johnnie-Walker-Red-Label-40%C2%B0-750-cc.jpg?v=638520760716300000"));
        listaDeNotificaciones.add(new Notificacion(5L, "Bebida Coca-Cola 2L", 2800, 50, "https://cugat.cl/wp-content/uploads/2021/04/cugat.cl-bebida-coca-cola-original-desechable-2-5lt.jpg"));
    }

    public List<Notificacion> obtenerTodos() {
        return listaDeNotificaciones;
    }

    public Notificacion buscarPorId(Long identificador) {
        return listaDeNotificaciones.stream()
                .filter(p -> p.getIdentificador().equals(identificador))
                .findFirst()
                .orElse(null);
    }
}