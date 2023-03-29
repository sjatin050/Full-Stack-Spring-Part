package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	// calling site from 3000 port to another port is called
	// Cross origin Requests
	// Tell Spring boot to allow all requests only from 3000

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // allowed all mappings
						.allowedMethods("*") // allowed all methods ->get ,  post , etc
						.allowedOrigins("http://localhost:3000"); // allowed request from port no 3000
			}
		};
	}


}
