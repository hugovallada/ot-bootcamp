package com.github.hugovallada.otbootcampcadastro.controller;

import com.github.hugovallada.otbootcampcadastro.dto.usuario.JwtResponseDTO;
import com.github.hugovallada.otbootcampcadastro.dto.usuario.UsuarioLoginRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping
    public JwtResponseDTO logar(@RequestBody UsuarioLoginRequestDTO usuario){
        System.out.println(usuario);
        return new JwtResponseDTO("Bearer", "Um token qlq");
    }

}
