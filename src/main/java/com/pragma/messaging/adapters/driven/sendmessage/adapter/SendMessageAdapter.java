package com.pragma.messaging.adapters.driven.sendmessage.adapter;

import com.pragma.messaging.domain.model.MessageToSend;
import com.pragma.messaging.domain.spi.SendMessageApiPort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendMessageAdapter implements SendMessageApiPort {
    private static final String ACCOUNT_SID = "AC939982115eec8c75ee67ca8906ca3298";

    private static final String TWILIO_PHONE_NUMBER = "+19046897898";

    @Override
    public void sendSms(MessageToSend message) {
        Twilio.init(ACCOUNT_SID, "AUTH_TOKEN");

       Message.creator(
                new PhoneNumber(message.getPhoneNumber()),
                new PhoneNumber(TWILIO_PHONE_NUMBER),
              message.getMessage()
        ).create();

    }
}
