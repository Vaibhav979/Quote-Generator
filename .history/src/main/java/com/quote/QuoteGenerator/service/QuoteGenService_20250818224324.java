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
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
        }

        String email = principal.getName();
        System.out.println();
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        quote.setUser(user);
        quoteRepository.save(quote);

        return ResponseEntity.ok("Quote added successfully!");
    }
}
