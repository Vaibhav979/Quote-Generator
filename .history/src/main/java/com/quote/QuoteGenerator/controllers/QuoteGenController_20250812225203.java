package com.quote.QuoteGenerator.controllers;

@RestController
@RequestMapping("/quote")
public class QuoteGenController {

    @Autowired
    private QuoteGenService quoteGenService;
    private String generateQuote(){
        return quoteGenService.getQuote();
    }
}
