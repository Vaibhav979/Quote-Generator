package com.quote.QuoteGenerator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quote.QuoteGenerator.model.Quotes;

public interface QuoteRepository extends JpaRepository<Quotes, Long> {
    // This interface will automatically provide CRUD operations for Quotes entity
    // Additional custom query methods can be defined here if needed
    
}
