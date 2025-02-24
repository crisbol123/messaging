package com.pragma.messaging.domain.model;

import org.springframework.data.annotation.Transient;

import java.util.Random;

public class MessageReady {
    private Long clientId;
    @Transient

    private String message;
    private Long orderId;
    private String phoneNumber;
    private String securityCode;

    public MessageReady(Long clientId, String message, Long orderId, String phoneNumber, String securityCode) {
        this.clientId = clientId;
        this.message = message;
        this.orderId = orderId;
        this.phoneNumber = phoneNumber;
        this.securityCode = securityCode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void generateRandomPin() {
        Random random = new Random();
        int pin = 1000 + random.nextInt(9000);
        this.securityCode = String.valueOf(pin);
    }
}
