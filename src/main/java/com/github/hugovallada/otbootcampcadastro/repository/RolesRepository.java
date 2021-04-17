package com.github.hugovallada.otbootcampcadastro.repository;

import com.github.hugovallada.otbootcampcadastro.modelo.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByTitulo(String titulo);
}
