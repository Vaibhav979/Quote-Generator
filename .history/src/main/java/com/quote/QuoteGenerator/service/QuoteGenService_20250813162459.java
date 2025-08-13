package com.quote.QuoteGenerator.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class QuoteGenService {
    private List<String> quotes = new ArrayList<>List.of(
            "The only limit to our realization of tomorrow is our doubts of today.",
            "Life is 10% what happens to us and 90% how we react to it.",
            "The future belongs to those who believe in the beauty of their dreams.",
            "It does not matter how slowly you go as long as you do not stop.",
            "First they will ask why you’re doing it. Later they’ll ask how you did it.",
            "One day, all the late nights and early mornings will pay off.",
            "One day, all the late nights and early mornings will pay off.",
            "The grind you’re avoiding today is the success you’ll miss tomorrow.",
            "Your future self is watching. Don’t let him down.",
            "Every rep, every bug fix, every late commit — it’s all building something.",
            "Work until the day you walk into your dream like it’s just another Monday.",
            "The view from the top is worth every step you’re taking now.",
            "One day, the world will call you lucky. You’ll know it was discipline.");

    private Random random = new Random();

    public String getQuote() {
        return quotes.get(random.nextInt(quotes.size()));
    }

    public String addQuote(String quote) {
        quotes.add(quote);
        return "Quote added successfully!";
    }
}
