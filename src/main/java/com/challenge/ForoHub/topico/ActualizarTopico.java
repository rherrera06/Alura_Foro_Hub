package com.challenge.ForoHub.topico;

import jakarta.validation.constraints.NotNull;

public record ActualizarTopico(@NotNull Long id, String titulo, String mensaje) {}