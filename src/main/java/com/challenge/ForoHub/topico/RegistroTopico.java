package com.challenge.ForoHub.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroTopico(@NotBlank String titulo, @NotBlank String mensaje, @NotNull Long idAutor, @NotNull Long idCurso) {}