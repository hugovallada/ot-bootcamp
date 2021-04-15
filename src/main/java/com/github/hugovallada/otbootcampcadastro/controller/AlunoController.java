package com.github.hugovallada.otbootcampcadastro.controller;

import com.github.hugovallada.otbootcampcadastro.dto.aluno.AlunoRequestDTO;
import com.github.hugovallada.otbootcampcadastro.dto.aluno.AlunoResponseDTO;
import com.github.hugovallada.otbootcampcadastro.modelo.Aluno;
import com.github.hugovallada.otbootcampcadastro.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    @CacheEvict(value = "listarAlunosCache", allEntries = true)
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

    @GetMapping
    @Cacheable(value = "listarAlunosCache")
    public Page<AlunoResponseDTO> listar(@PageableDefault  Pageable paginacao){
        Page<Aluno> alunos = alunoRepository.findAll(paginacao);
        return alunos.map(AlunoResponseDTO::new);
    }
}
