package com.quote.QuoteGenerator.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quote.QuoteGenerator.Repository.QuoteRepository;
import com.quote.QuoteGenerator.Repository.UserRepository;
import com.quote.QuoteGenerator.model.Quotes;
import com.quote.QuoteGenerator.model.User;
import com.quote.QuoteGenerator.service.QuoteGenService;

@RestController
@RequestMapping("/quote")
@CrossOrigin(origins = "http://localhost:5173")
public class QuoteGenController {

    @Autowired
    private QuoteGenService quoteGenService;

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    private String generateQuote() {
        return quoteGenService.getQuote();
    }

    @PostMapping("/add")
    private ResponseEntity<String> addQuote(@RequestBody Quotes quote, Principal principal) {
        return quoteGenService.addQuote(quote, principal);
    }

    @GetMapping("/dashboard")
    public List<Quotes> getAllQuotesByUser(@RequestBody String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        return quoteRepository.findByUser(user);
    }
}
