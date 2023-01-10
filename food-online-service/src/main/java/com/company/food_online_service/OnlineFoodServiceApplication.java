package com.company.food_online_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OnlineFoodServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineFoodServiceApplication.class, args);
    }
}