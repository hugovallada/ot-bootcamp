package com.github.hugovallada.otbootcampcadastro.repository;

import com.github.hugovallada.otbootcampcadastro.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
