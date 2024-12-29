package com.empresa.investimento.controller;


import com.empresa.investimento.model.entity.User;
import com.empresa.investimento.infra.security.TokenService;
import com.empresa.investimento.model.dto.AuthenticationDTO;
import com.empresa.investimento.model.dto.LoginResponseDTO;
import com.empresa.investimento.model.dto.RegisterDTO;
import com.empresa.investimento.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        System.out.println("Tentativa de login com usuário: " + data.login());
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());
            System.out.println("Login bem-sucedido para usuário: " + data.login());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (Exception e) {
            System.err.println("Erro ao tentar autenticar usuário: " + data.login());
            e.printStackTrace();
            return ResponseEntity.status(403).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.email(), data.cpf(), data.address(), data.phone(), data.role());
        this.repository.save(newUser);
        System.out.printf("Usuário salvo " + newUser.getLogin());
        return ResponseEntity.ok().build();
    }
}