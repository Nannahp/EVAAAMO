package com.example.evaaamo.services;

import com.example.evaaamo.entities.User;
import com.example.evaaamo.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    LoginRepository loginRepository;

    //Directly injected passwordEncoder
    @Autowired
    PasswordEncoder passwordEncoder;

    //Finds user, encodes the password and saves it - Throws exception, if user not found
    public void changePassword(String email, String newPassword) {
        User user = loginRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        user.setPassword(passwordEncoder.encode(newPassword));
        loginRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return loginRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

}
