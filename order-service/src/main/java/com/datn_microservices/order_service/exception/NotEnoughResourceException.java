package com.datn_microservices.order_service.exception;

public class NotEnoughResourceException extends RuntimeException {
    public NotEnoughResourceException(String message) {
        super(message);
    }
}
