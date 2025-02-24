package com.pragma.messaging.adapters.driven.feigns.exception;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String message) {
        super( message);
    }
}
