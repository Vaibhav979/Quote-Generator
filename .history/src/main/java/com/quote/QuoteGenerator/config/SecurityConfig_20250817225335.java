package com.quote.QuoteGenerator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeRequests(auth -> auth 
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/quotes/add").authenticated()
                .anyRequest().permitAll()
            )
        .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())) // Only if using JWT
            .httpBasic(Customizer.withDefaults()); // Enables basic auth (for development)

        return http.build();    
    }
}
