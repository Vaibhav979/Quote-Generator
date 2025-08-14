package com.quote.QuoteGenerator.Repository;

public interface QuoteRepository extends JpaRepository<Quotes, Long> {
    // This interface will automatically provide CRUD operations for Quotes entity
    // Additional custom query methods can be defined here if needed
    
}
