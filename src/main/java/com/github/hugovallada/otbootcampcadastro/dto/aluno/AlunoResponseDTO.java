package com.github.hugovallada.otbootcampcadastro.dto.aluno;

import com.github.hugovallada.otbootcampcadastro.modelo.Aluno;

public class AlunoResponseDTO {

    private String nome;

    private String email;

    public AlunoResponseDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public AlunoResponseDTO (Aluno aluno) {
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
    }

    public AlunoResponseDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
