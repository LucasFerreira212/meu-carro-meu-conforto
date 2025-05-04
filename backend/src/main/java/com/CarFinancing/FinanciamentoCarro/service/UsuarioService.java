package com.CarFinancing.FinanciamentoCarro.service;

import com.CarFinancing.FinanciamentoCarro.entities.Usuario;
import com.CarFinancing.FinanciamentoCarro.enums.Papel;
import com.CarFinancing.FinanciamentoCarro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List<Usuario> listarClientes() {
        return usuarioRepository.findByTipoUsuario(Papel.CLIENTE);
    }

    public List<Usuario> listarFuncionarios() {
        return usuarioRepository.findByTipoUsuario(Papel.FUNCIONARIO);
    }

    public List<Usuario> listarGerentes() {
        return usuarioRepository.findByTipoUsuario(Papel.GERENTE);
    }
}
