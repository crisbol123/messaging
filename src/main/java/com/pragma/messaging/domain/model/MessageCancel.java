package com.pragma.messaging.domain.model;

public class MessageCancel  {
    private Long clientId;
    private String message;

    public MessageCancel(Long clientId,  String message) {
        this.clientId = clientId;
        this.message = message;
    }


    public Long getClientId() {
        return clientId;
    }

    public String getMessage() {
        return message;
    }
}
