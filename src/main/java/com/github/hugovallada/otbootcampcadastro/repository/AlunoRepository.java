package com.github.hugovallada.otbootcampcadastro.repository;

import com.github.hugovallada.otbootcampcadastro.modelo.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
