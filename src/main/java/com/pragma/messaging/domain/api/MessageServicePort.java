package com.pragma.messaging.domain.api;


import com.pragma.messaging.domain.model.MessageCancel;
import com.pragma.messaging.domain.model.MessageReady;

public interface MessageServicePort {
    void sendMessageReady(MessageReady messageReady);
    void sendMessageCanceled(MessageCancel messageCancel);
    boolean verifySecurityCode(String securityCode, Long orderId);
}