package com.github.hugovallada.otbootcampcadastro.dto.usuario;

import com.github.hugovallada.otbootcampcadastro.modelo.Roles;
import com.github.hugovallada.otbootcampcadastro.modelo.Usuario;
import com.github.hugovallada.otbootcampcadastro.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CadastroUsuarioRequestDTO {

    private String nome;

    private String email;

    private String senha;

    private Integer idade;

    public CadastroUsuarioRequestDTO(String nome, String email, String senha, Integer idade) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Usuario toModel(RolesRepository rolesRepository){
        BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
        Roles role = rolesRepository.findByTitulo("ROLE_ALUNO").get();

        System.out.println(role.getAuthority());

        List<Roles> roles = new ArrayList<>();
        roles.add(role);

        return new Usuario(nome, email, encoder.encode(senha), idade, roles);

    }
}
