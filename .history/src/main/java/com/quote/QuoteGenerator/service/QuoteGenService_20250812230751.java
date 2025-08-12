package com.quote.QuoteGenerator.service;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class QuoteGenService {
    private final List<String> quotes = List.of(
    "The only limit to our realization of tomorrow is our doubts of today.",
    "Life is 10% what happens to us and 90% how we react to it.",
    "The future belongs to those who believe in the beauty of their dreams.",
    "It does not matter how slowly you go as long as you do not stop.",
    "First they will ask why you’re doing it. Later they’ll ask how you did it.",
    "One day, all the late nights and early mornings will pay off."
);


    private Random random = new Random();

    public String getQuote() {
        return quotes.get(random.nextInt(quotes.size()));
    }
}
