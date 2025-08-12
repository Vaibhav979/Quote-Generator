package com.quote.QuoteGenerator.controllers;

@RestController
@RequestMapping("/quote")
public class QuoteGenController {
    private QuoteGenService quoteGenService;
    private String generateQuote(){
        return quoteGenService.getQuote();
    }
}
