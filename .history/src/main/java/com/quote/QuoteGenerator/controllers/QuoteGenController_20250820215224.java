package com.quote.QuoteGenerator.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quote.QuoteGenerator.Repository.UserRepository;
import com.quote.QuoteGenerator.model.Quotes;
import com.quote.QuoteGenerator.model.User;
import com.quote.QuoteGenerator.service.QuoteGenService;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class QuoteGenController {

    @Autowired
    private QuoteGenService quoteGenService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/quote")
    private String generateQuote() {
        return quoteGenService.getQuote();
    }

    @PostMapping("/quote/add")
    private ResponseEntity<String> addQuote(@RequestBody Quotes quote, Principal principal) {
        return quoteGenService.addQuote(quote, principal);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<List<Quotes>> getAllQuotesByUser(Principal principal) {
        return quoteGenService.getAllQuotesByUser(principal);
    }

    @GetMapping("/current-user")
    public ResponseEntity<?> getCurrentUser(Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not logged in"); // Unauthorized response if
                                                                                         // principal is null
        }
        String email = principal.getName();
        Optional<User> user = userRepository.findByEmail(email);
        return user.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found"));
    }

    @PutMapping("/quote/update{id}")
    public ResponseEntity<String> updateQuote(@PathVariable Long id, @RequestBody Quotes quote, Principal principal) {
        return quoteGenService.updateQuote(id, quote, principal);
    }

    @DeleteMapping("/quote/delete/{id}")
    public ResponseEntity<String> deleteQuote(@PaqthVa)

}
