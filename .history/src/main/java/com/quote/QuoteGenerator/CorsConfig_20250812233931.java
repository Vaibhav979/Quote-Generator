package com.quote.QuoteGenerator;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer () {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping
            }
        }
    }
}
