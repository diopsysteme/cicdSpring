package org.SchoolApp.Services.Impl;

import org.SchoolApp.Services.Interfaces.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    @Override
    public void sendAuthenticationEmail(String email, String login, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your Login Credentials");
        message.setText("Login: " + login + "\nPassword: " + password + "\nPlease change your password after login.");
        mailSender.send(message);  // Send email
    }
}
