package com.quote.QuoteGenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quote.QuoteGenerator.Repository.QuoteRepository;
import com.quote.QuoteGenerator.Repository.UserRepository;
import com.quote.QuoteGenerator.model.Quotes;
import com.quote.QuoteGenerator.model.User;

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

    public String addQuote(String quote, String user) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        quote.setUser(user);
        quoteRepository.save(quote);
        return "Quote added successfully!";
    }
}
