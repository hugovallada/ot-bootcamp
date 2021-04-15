package com.github.hugovallada.otbootcampcadastro.dto.usuario;

public class JwtResponseDTO {
    private String tipo;

    private String token;

    public JwtResponseDTO() {
    }

    public JwtResponseDTO(String tipo, String token) {
        this.tipo = tipo;
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
