package com.pragma.messaging.domain.use_cases;

import com.pragma.messaging.domain.api.MessageServicePort;
import com.pragma.messaging.domain.model.MessageToSend;
import com.pragma.messaging.domain.model.MessageCancel;
import com.pragma.messaging.domain.model.MessageReady;
import com.pragma.messaging.domain.spi.MessagePersistancePort;
import com.pragma.messaging.domain.spi.SendMessageApiPort;
import com.pragma.messaging.domain.spi.UserFeignClientPort;

public class MessageUseCase implements MessageServicePort {
    private final UserFeignClientPort userFeignClientPort;
    private final MessagePersistancePort messagePersistancePort;
private final SendMessageApiPort sendMessageApiPort;


    public MessageUseCase(UserFeignClientPort userFeignClientPort, MessagePersistancePort messagePersistancePort, SendMessageApiPort sendMessageApiPort) {
        this.userFeignClientPort = userFeignClientPort;
        this.messagePersistancePort = messagePersistancePort;
        this.sendMessageApiPort = sendMessageApiPort;
    }

    @Override
    public void sendMessageReady(MessageReady messageReady) {
        String phoneNumber = userFeignClientPort.getPhoneNumber(messageReady.getClientId());
        messageReady.generateRandomPin();
        System.out.println("Security code: " + messageReady.getSecurityCode());
        messageReady.setPhoneNumber(phoneNumber);
        messageReady.setMessage(messageReady.getMessage() + " your pin is: " + messageReady.getSecurityCode());
        messagePersistancePort.saveMessage(messageReady);
        MessageToSend messageToSend = new MessageToSend( messageReady.getPhoneNumber(), messageReady.getMessage());
        sendMessageApiPort.sendSms(messageToSend);
    }

    @Override
    public void sendMessageCanceled(MessageCancel messageCancel) {
        String phoneNumber = userFeignClientPort.getPhoneNumber(messageCancel.getClientId());
        MessageToSend messageToSend = new MessageToSend( phoneNumber, messageCancel.getMessage());
        sendMessageApiPort.sendSms(messageToSend);
    }

    @Override
    public boolean verifySecurityCode(String securityCode, Long orderId) {
        return messagePersistancePort.verifySecurityCode(orderId,securityCode);
    }
}
