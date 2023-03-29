package com.in28minutes.rest.webservices.restfulwebservices.basic;

/**
 * this java file is made after adding spring security in pom.xml file
 */

import org.springframework.context.annotation.Bean;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration // after adding jwt dont wont that it will work .. so comment out
public class BasicAuthenticationSecurityConfiguration {

    //Filter chain
    // authenticate all requests
    //basic authentication
    //disabling csrf
    //stateless rest api



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //1: Response to preflight request doesn't pass access control check
        //2: basic auth --> done in HelloWorldController.java file

        //return http.build();  // if i just write this thing then this will disable all security features.
        // http supports chaining
        return http.authorizeHttpRequests(
                                auth -> auth
                                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Response to preflight request doesn't pass access control check
                                        .anyRequest().authenticated()
                        )
                        .httpBasic(Customizer.withDefaults()) // this will enable a popUP asking for username and password
                        .sessionManagement(session -> session.sessionCreationPolicy
                                        (SessionCreationPolicy.STATELESS))
                        .csrf().disable()
                        .build();
    }
}
