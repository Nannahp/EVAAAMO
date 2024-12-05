package com.example.evaaamo.services;

import com.example.evaaamo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MailService {

    @Autowired
    LoginService loginService;

    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(String recipient, String newPassword) {
        SimpleMailMessage message = new SimpleMailMessage();

        //Set the recipient, subject, and content of the email
        message.setTo(recipient);
        message.setSubject("New password");
        message.setText("Here is your new password: " + newPassword);

        //Send the email using JavaMailSender
        javaMailSender.send(message);
    }


    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA5]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        //Check if the email matches the regex
        if (!matcher.matches()) {
            return false;
        }

        //Check if the user exists and if their email matches
        User user = loginService.findUserByEmail(email);
        return user != null && user.getEmail().equals(email);
    }
}
