package com.example.evaaamo.configs;

import com.example.evaaamo.entities.User;
import com.example.evaaamo.repositories.LoginRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitUser implements CommandLineRunner {
    private LoginRepository loginRepository;
    private PasswordEncoder passwordEncoder;

    public InitUser(LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        //Check if user already exists
        User existingUser = loginRepository.findUserByEmail("evaaamo@gmail.com");
        if (existingUser == null) {
            //Create default user
            User defaultUser = new User();
            defaultUser.setEmail("admin@gmail.com");
            defaultUser.setPassword(passwordEncoder.encode("321"));

            //Save user
            loginRepository.save(defaultUser);
            System.out.println("User created with email: " + defaultUser.getEmail());
        }
    }
}
