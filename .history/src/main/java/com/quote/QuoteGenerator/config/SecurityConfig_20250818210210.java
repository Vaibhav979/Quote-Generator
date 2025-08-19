package com.quote.QuoteGenerator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/quote/add").authenticated()
                        .anyRequest().permitAll())
                .oauth2Login()
        .and()
        .logout().logoutSuccessUrl("http://localhost:5173");        
                // .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())) //
                // Only if using JWT
                .httpBasic(Customizer.withDefaults()); // Enables basic auth (for development)

        return http.build();
    }
}
