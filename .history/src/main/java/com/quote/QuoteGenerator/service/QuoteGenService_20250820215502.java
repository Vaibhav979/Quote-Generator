package com.quote.QuoteGenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quote.QuoteGenerator.Repository.QuoteRepository;
import com.quote.QuoteGenerator.Repository.UserRepository;
import com.quote.QuoteGenerator.model.Quotes;
import com.quote.QuoteGenerator.model.User;

import java.security.Principal;
import java.util.List;
import java.util.Random;

@Service
public class QuoteGenService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private UserRepository userRepository;

    private Random random = new Random();

    public String getQuote() {
        List<Quotes> quotes = quoteRepository.findAll();
        Quotes quote = quotes.get(random.nextInt(quotes.size()));
        return quote.getQuote();
    }

    public ResponseEntity<String> addQuote(Quotes quote, Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
        }

        String email = principal.getName();
        System.out.println("Adding quote for user: " + email);
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        quote.setUser(user);
        quoteRepository.save(quote);

        return ResponseEntity.ok("Quote added successfully!");
    }

    public ResponseEntity<List<Quotes>> getAllQuotesByUser(Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String email = principal.getName();
        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<Quotes> myQuotes = quoteRepository.findByUser(user);
        return ResponseEntity.ok(myQuotes);
    }

    public ResponseEntity<String> updateQuote(Long id, Quotes quote, Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
        }
        String email = principal.getName();
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        Quotes existingQuote = quoteRepository.findById(id).orElse(null);
        if (existingQuote == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quote not found");
        }
        if (!existingQuote.getUser().equals(user)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You can only update your own quotes");
        }
        if (quote.getQuote() == null || quote.getQuote().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Quote content cannot be empty");
        }

        existingQuote.setQuote(quote.getQuote());
        quoteRepository.save(existingQuote);
        return ResponseEntity.ok("Quote updated successfully.");
    }

    public ResponseEntity<String> deleteQuote(Long id, Principal principal) {
        ifpr
    }
}
