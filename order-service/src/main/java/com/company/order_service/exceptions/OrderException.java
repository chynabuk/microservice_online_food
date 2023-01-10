package com.company.order_service.exceptions;

public class OrderException extends RuntimeException{
    public OrderException(String message) {
        super("Order: " + message);
    }
}
