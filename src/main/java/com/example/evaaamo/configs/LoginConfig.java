package com.example.evaaamo.configs;

import com.example.evaaamo.entities.User;
import com.example.evaaamo.repositories.LoginRepository;
import com.example.evaaamo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class LoginConfig {
    @Autowired
    LoginService loginService;

    //Beans managed by Spring IoC so we can inject them if needed, or else just use them
    //Bean to define the security setting
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").authenticated() //Only admin routes require login
                        .anyRequest().permitAll() //All other pages are always available
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll() //Login page is always public
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/") //Redirect to homepage after logout
                );

        return http.build();
    }

    //Handles the actual authentication
    //This is where the authentication object is created and stored in Security Context (session-based)
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder, LoginService loginService) throws Exception {
        //Gets the helper class object so we can use it for authentication
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder
                .userDetailsService(loginService) //Tells to use LoginService to load user details from db
                .passwordEncoder(passwordEncoder); //Tells to use passwordEncoder

        return authBuilder.build(); //Builds the manager that is used to authenticate user and is now resposible for it
    }

    //Creates test user for h2 db
    @Bean
    public CommandLineRunner createTestUser(LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (loginRepository.findUserByEmail("admin@example.com").isEmpty()) {
                User user = new User();
                user.setEmail("admin@example.com");
                user.setPassword(passwordEncoder.encode("password123")); // Encrypt the password
                loginRepository.save(user);
                System.out.println("Test user created: admin@example.com / password123");
            }
        };
    }

}
