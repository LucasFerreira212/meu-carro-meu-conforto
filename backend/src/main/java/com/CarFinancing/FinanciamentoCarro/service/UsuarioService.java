package com.CarFinancing.FinanciamentoCarro.service;

import com.CarFinancing.FinanciamentoCarro.entities.Usuario;
import com.CarFinancing.FinanciamentoCarro.enums.Papel;
import com.CarFinancing.FinanciamentoCarro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
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
