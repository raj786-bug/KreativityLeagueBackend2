package com.kreativity.studentregister;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                    .allowedOrigins("https://kreativityleague.com","http://127.0.0.1:5502","http://127.0.0.1:5504") // Add your web app's origin here
	                    .allowedMethods("GET", "POST", "PUT", "DELETE")
	                    .allowedHeaders("*");
	            }
	        };
	    }

}
