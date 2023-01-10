package com.company.email_sender_service.controller;

import com.company.email_sender_service.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/send")
    public String send(@RequestParam(value = "to", required = true) String to,
                       @RequestParam(value = "subject", required = false, defaultValue = "") String subject,
                       @RequestParam(value = "body", required = false, defaultValue = "") String body){
        return emailService.sendEmail(to, subject, body);
    }
}