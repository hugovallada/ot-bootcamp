package com.github.hugovallada.otbootcampcadastro.controller;

import com.github.hugovallada.otbootcampcadastro.dto.aluno.AlunoRequestDTO;
import com.github.hugovallada.otbootcampcadastro.dto.aluno.AlunoResponseDTO;
import com.github.hugovallada.otbootcampcadastro.modelo.Aluno;
import com.github.hugovallada.otbootcampcadastro.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid AlunoRequestDTO dto){
        alunoRepository.save(dto.toModel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> detalhes(@PathVariable Long id){
        Optional<Aluno> alunoOpt = alunoRepository.findById(id);

        if(alunoOpt.isPresent()){
            return ResponseEntity.ok(new AlunoResponseDTO(alunoOpt.get()));
        }

        return ResponseEntity.notFound().build();

    }
}
