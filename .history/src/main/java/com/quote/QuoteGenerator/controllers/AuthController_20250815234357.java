package com.quote.QuoteGenerator.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @PostMapping("/google")
    public ResponseEntity<?> googelLogin(@RequestBody Map<String, String> payload) {
        String idTokenString = payload.get("credential");

        GoogleIdToken idToken = verifyToken(idTokeString)
        
        return entity;
    }
    
}
