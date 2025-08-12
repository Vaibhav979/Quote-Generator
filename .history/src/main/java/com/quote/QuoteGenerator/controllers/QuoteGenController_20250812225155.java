package com.quote.QuoteGenerator.controllers;

@RestController
@RequestMapping("/quote")
public class QuoteGenController {
    private Quote
    private String generateQuote(){
        return quoteGenService.getQuote();
    }
}
