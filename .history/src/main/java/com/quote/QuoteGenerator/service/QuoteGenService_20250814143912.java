package com.quote.QuoteGenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quote.QuoteGenerator.Repository.QuoteRepository;
import com.quote.QuoteGenerator.model.Quotes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuoteGenService {
    
    @Autowired
    private QuoteRepository quoteRepository;

    private Random random = new Random();

    public String getQuote() {
        List<Quotes> quotes = quoteRepository.findAll();
        Quote  quotes.get(random.nextInt(quotes.size()));
    }

    public String addQuote(String quote) {
        quotes.add(quote);
        return "Quote added successfully!";
    }
}
