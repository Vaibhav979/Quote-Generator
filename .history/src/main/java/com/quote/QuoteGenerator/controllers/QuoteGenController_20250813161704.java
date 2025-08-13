package com.quote.QuoteGenerator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quote.QuoteGenerator.service.QuoteGenService;

@RestController
@RequestMapping("/quote")
@CrossOrigin(origins = "http://localhost:5173")
public class QuoteGenController {

    @Autowired
    private QuoteGenService quoteGenService;

    @GetMapping
    private String generateQuote() {
        return quoteGenService.getQuote();
    }

    @PostMapping("/add")
    private String addQuote(@RequestBody String quote) {
        return quoteGenService.addQuote(quote);
    } 
}
