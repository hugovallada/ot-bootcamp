package com.github.hugovallada.otbootcampcadastro.controller;

import com.github.hugovallada.otbootcampcadastro.config.security.TokenService;
import com.github.hugovallada.otbootcampcadastro.dto.usuario.JwtResponseDTO;
import com.github.hugovallada.otbootcampcadastro.dto.usuario.UsuarioLoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public JwtResponseDTO logar(@RequestBody UsuarioLoginRequestDTO usuario){
        UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha());
        Authentication authentication = authenticationManager.authenticate(upat);
        String token = tokenService.gerarToken(authentication);
        return new JwtResponseDTO("Bearer", token);
    }

}
