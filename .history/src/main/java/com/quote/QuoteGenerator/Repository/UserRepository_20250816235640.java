package com.quote.QuoteGenerator.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quote.QuoteGenerator.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);    
}
