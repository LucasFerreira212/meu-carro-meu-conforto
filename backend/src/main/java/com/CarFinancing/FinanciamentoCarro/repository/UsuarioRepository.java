package com.CarFinancing.FinanciamentoCarro.repository;

import com.CarFinancing.FinanciamentoCarro.entities.Usuario;
import com.CarFinancing.FinanciamentoCarro.enums.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    @Override
    @NonNull
    Optional<Usuario> findById(@NonNull Long id);
    List<Usuario> findByTipoUsuario(Papel papel);
}
