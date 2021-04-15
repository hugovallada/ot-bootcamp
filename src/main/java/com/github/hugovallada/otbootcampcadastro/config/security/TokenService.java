package com.github.hugovallada.otbootcampcadastro.config.security;

import com.github.hugovallada.otbootcampcadastro.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class TokenService {

    @Value("${ot-bootcamp.jwt.secret}")
    private String secret;

    @Value(("${ot-bootcamp.jwt.expiration}"))
    private String expiration;

    public String gerarToken(Authentication authentication){
        Usuario usuario = (Usuario) authentication.getPrincipal();

        return Jwts.builder()
                .setIssuer("OT-Bootcamp")
                .setSubject(usuario.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + Long.parseLong(expiration)))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }
}
