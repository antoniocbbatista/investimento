package com.empresa.investimento.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity(name = "users")
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String login;

    private String password;

    private String email;

    private String cpf;

    private String address;

    private String phone;

    private Double balance;

    private UserRole role;

    public User() {
    }

    public User(String login, String password, String email, String cpf, String address, String phone, String role){
        this.login = login;
        this.password = password;
        this.email = email;
        this.cpf = cpf;
        this.address = address;
        this.phone = phone;
        this.role = UserRole.valueOf(role);
    }


    public User(UUID id, String login, String password, String email, String cpf, String address, String phone, Double balance, UserRole role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.cpf = cpf;
        this.address = address;
        this.phone = phone;
        this.balance = balance;
        this.role = role;
    }

    public User(String login, String password, String role, String email) {
        this.login = login;
        this.password = password;
        this.role = UserRole.valueOf(role);
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}