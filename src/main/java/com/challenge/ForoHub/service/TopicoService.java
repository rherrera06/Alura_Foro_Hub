package com.challenge.ForoHub.service;

import com.challenge.ForoHub.curso.Curso;
import com.challenge.ForoHub.repositorio.CursoRepository;
import com.challenge.ForoHub.repositorio.TopicoRepository;
import com.challenge.ForoHub.repositorio.UsuarioRepository;
import com.challenge.ForoHub.topico.ActualizarTopico;
import com.challenge.ForoHub.topico.RegistroTopico;
import com.challenge.ForoHub.topico.Topico;
import com.challenge.ForoHub.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public Topico crearTopico(RegistroTopico datos) {
        Usuario autor = usuarioRepository.findById(datos.idAutor()).orElseThrow(() -> new IllegalArgumentException("Autor no encontrado"));
        Curso curso = cursoRepository.findById(datos.idCurso()).orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
        Topico topico = new Topico(datos, autor, curso);
        return topicoRepository.save(topico);
    }

    public Topico actualizarTopico(ActualizarTopico datos) {
        Topico topico = topicoRepository.findById(datos.id()).orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado"));
        topico.actualizarDatos(datos);
        return topico;
    }
}
