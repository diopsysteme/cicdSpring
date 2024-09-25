package org.SchoolApp.Services.Interfaces;

public interface EmailService {
    void sendAuthenticationEmail(String email, String login, String password);
}
