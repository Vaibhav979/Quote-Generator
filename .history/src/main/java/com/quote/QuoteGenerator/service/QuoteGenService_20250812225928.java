package com.quote.QuoteGenerator.service;

@Service
import java.util.List;
public class QuoteGenService {
    private final List<String> quotes = List.of(
        "The only limit to our realization of tomorrow is our doubts of today.",
        "Life is 10% what happens to us and 90% how we react to it.",
        "The future belongs to those who believe in the beauty of their dreams.",
        "It does not matter how slowly you go as long as you do not stop.",
        "You are never too old to set another goal or to dream a new dream.",
        "Success is not final, failure is not fatal: It is the courage to continue that counts.",
        "Believe you can and you're halfway there."
    );

    private Random random = new Random();

    public String getQuote() {
        return quotes.get(random.nextInt(quotes.size()))
    }
}
