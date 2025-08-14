package com.quote.QuoteGenerator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quotes")
public class Quotes {
    @id
    private Long id;
    private String quote;
}
