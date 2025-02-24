package com.pragma.messaging.domain.spi;

import com.pragma.messaging.domain.model.MessageReady;

public interface MessagePersistancePort {
    void saveMessage(MessageReady messageReady);
    boolean verifySecurityCode(Long orderId, String securityCode);
}
