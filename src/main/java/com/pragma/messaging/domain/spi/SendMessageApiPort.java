package com.pragma.messaging.domain.spi;


import com.pragma.messaging.domain.model.MessageToSend;

public interface SendMessageApiPort {
    void sendSms(MessageToSend message);
}
