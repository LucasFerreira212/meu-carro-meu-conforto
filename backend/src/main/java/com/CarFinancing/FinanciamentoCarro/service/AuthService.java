package com.CarFinancing.FinanciamentoCarro.service;

import com.CarFinancing.FinanciamentoCarro.entities.Usuario;
import com.CarFinancing.FinanciamentoCarro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Usuario> autenticar(String email, String senhaDigitada) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            if (passwordEncoder.matches(senhaDigitada, usuario.getSenha())) {
                return Optional.of(usuario);
            }
        }

        return Optional.empty();
    }
}
