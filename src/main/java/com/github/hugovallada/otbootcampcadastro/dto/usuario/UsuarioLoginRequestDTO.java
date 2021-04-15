package com.github.hugovallada.otbootcampcadastro.dto.usuario;

import com.github.hugovallada.otbootcampcadastro.modelo.Usuario;

public class UsuarioLoginRequestDTO {

    private String email;

    private String senha;

    public UsuarioLoginRequestDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public UsuarioLoginRequestDTO() {
    }

    public Usuario toModel(){
        return new Usuario(email, senha);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
