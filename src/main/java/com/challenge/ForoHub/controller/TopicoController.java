package com.challenge.ForoHub.controller;

import com.challenge.ForoHub.repositorio.TopicoRepository;
import com.challenge.ForoHub.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private com.challenge.ForoHub.service.TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalleTopico> registrarTopico(@RequestBody @Valid RegistroTopico datos, UriComponentsBuilder uriBuilder) {
        Topico topico = topicoService.crearTopico(datos);
        URI url = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DetalleTopico>> listadoTopicos(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DetalleTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetalleTopico> actualizarTopico(@RequestBody @Valid ActualizarTopico datos) {
        Topico topico = topicoService.actualizarTopico(datos);
        return ResponseEntity.ok(new DetalleTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}