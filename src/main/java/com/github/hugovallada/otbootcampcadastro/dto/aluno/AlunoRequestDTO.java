package com.github.hugovallada.otbootcampcadastro.dto.aluno;

import com.github.hugovallada.otbootcampcadastro.modelo.Aluno;
import org.hibernate.validator.constraints.Length;

import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

public class AlunoRequestDTO {

    @NotEmpty
    @Length(min = 3, max = 30)
    private String nome;

    @Email
    @Length(min = 10, max = 30)
    private String email;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer idade;


    public AlunoRequestDTO() {
    }

    public AlunoRequestDTO(String nome, String email, Integer idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Integer getIdade() {
        return idade;
    }

    public Aluno toModel(){
        return new Aluno(nome, email,idade );
    }
}
