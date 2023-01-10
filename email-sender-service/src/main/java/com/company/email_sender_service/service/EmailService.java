package com.company.email_sender_service.service;

public interface EmailService {
    String sendEmail(String to, String subject, String body);
}
