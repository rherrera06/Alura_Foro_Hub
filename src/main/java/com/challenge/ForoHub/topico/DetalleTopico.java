package com.challenge.ForoHub.topico;

import java.time.LocalDateTime;

public record DetalleTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion) {
    public DetalleTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
    }
}