package com.CarFinancing.FinanciamentoCarro.controller;

import com.CarFinancing.FinanciamentoCarro.entities.Usuario;
import com.CarFinancing.FinanciamentoCarro.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Usuario>> listarClientes() {
        return ResponseEntity.ok(usuarioService.listarClientes());
    }

    @GetMapping("/funcionarios")
    public ResponseEntity<List<Usuario>> listarFuncionarios() {
        return ResponseEntity.ok(usuarioService.listarFuncionarios());
    }

    @GetMapping("/gerentes")
    public ResponseEntity<List<Usuario>> listarGerentes() {
        return ResponseEntity.ok(usuarioService.listarGerentes());
    }
}
