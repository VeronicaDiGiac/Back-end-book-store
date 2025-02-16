package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	  @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**") // Consente CORS su tutte le rotte
	                .allowedOrigins("http://127.0.0.1:5500") // Aggiungi il tuo dominio front-end
	                .allowedMethods("GET", "POST", "PUT", "DELETE") // Metodi permessi
	                .allowedHeaders("*");
	    }
}