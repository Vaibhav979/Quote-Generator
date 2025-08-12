package com.quote.QuoteGenerator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quote.QuoteGenerator.service.QuoteGenService;

@RestController
@RequestMapping("/quote")
public class QuoteGenController {

    @Autowired
    private QuoteGenService quoteGenService;
    
    
    private String generateQuote(){
        return quoteGenService.getQuote();
    }
}
