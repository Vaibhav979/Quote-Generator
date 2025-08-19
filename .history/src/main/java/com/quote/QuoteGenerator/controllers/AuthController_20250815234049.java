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
    public ResponseEntity< postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
}
