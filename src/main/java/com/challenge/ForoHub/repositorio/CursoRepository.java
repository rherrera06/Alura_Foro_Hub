package com.challenge.ForoHub.repositorio;

import com.challenge.ForoHub.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {}