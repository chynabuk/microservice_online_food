package com.company.email_sender_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmailSenderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailSenderServiceApplication.class, args);
    }
}
