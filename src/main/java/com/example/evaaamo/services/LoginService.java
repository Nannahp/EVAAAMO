package com.example.evaaamo.services;

import com.example.evaaamo.entities.User;
import com.example.evaaamo.repositories.LoginRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Random;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    HttpSession session;

    public User findUserByEmail(String email) {
        return loginRepository.findUserByEmail(email);
    }

    public boolean authenticateUser(String email, String password) {
        User user = findUserByEmail(email);
        if (user != null) {
            String storedPassword = user.getPassword();
            if (verifyPassword(password, storedPassword)) {
                session.setAttribute("loggedIn", true);
                return true; //Authentication successful
            } else {
                return false; //Password mismatch
            }
        } else {
            return false; //User not found
        }
    }

    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        return passwordEncoder.matches(password, hashedPassword);
    }

    public boolean isUserLoggedIn(HttpSession session) {
        return session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn");
    }

    public String randomPassword() {
        String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(validChars.length());
            password.append(validChars.charAt(index));
        }
        return password.toString();
    }

    @Transactional //Needed so it can roll back in case there is an error when updating
    public void updatePassword(String password, String email) {
        String hashedPassword = hashPassword(password);
        loginRepository.updatePasswordByEmail(email, hashedPassword);
    }

}
