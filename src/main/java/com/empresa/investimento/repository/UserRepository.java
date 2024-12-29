package com.empresa.investimento.repository;

import com.empresa.investimento.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;



public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
}