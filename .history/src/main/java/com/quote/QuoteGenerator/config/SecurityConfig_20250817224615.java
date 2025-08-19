package com.quote.QuoteGenerator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF protection for simplicity
            .authorizeRequests()
                .anyRequest().permitAll() // Allow all requests for now
                .and()
            .httpBasic(); // Enable basic authentication

        return http.build();
}
