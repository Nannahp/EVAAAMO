package com.example.evaaamo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Ont its own, so there isnt a conflicting loop between config and LoginService
@Configuration
public class PasswordConfig {

    //PasswordEncoder is an interface in Spring Security
    //
    @Bean
    public PasswordEncoder passwordEncoder() {
        //We use bcrypt, a hashing algorithm that includes a salt mechanism already in it
        //Adaptive cost factor (how many times its hashed) in its default settings, so secure regarding brute force attacks
        //Basically easier to use and more secure
        return new BCryptPasswordEncoder();
    }
}
