package com.pragma.messaging.adapters.driven.mongodb.adapters;

import com.pragma.messaging.adapters.driven.mongodb.entities.MessageStorage;
import com.pragma.messaging.adapters.driven.mongodb.mapper.MessageEntityMapper;
import com.pragma.messaging.adapters.driven.mongodb.repository.MessageRepository;
import com.pragma.messaging.domain.model.MessageReady;
import com.pragma.messaging.domain.spi.MessagePersistancePort;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
public class MessageAdapter implements MessagePersistancePort {
    private final PasswordEncoder passwordEncoder;
private final MessageEntityMapper messageEntityMapper;
    private final MessageRepository messageRepository;
    @Override
    public void saveMessage(MessageReady messageReady) {
        MessageStorage messageStorage = messageEntityMapper.toEntity(messageReady);
        messageStorage.setOrderId(messageReady.getOrderId());
   messageStorage.setSecurityCode(passwordEncoder.encode(messageReady.getSecurityCode()));
        messageRepository.save(messageStorage);
    }

    @Override
    public boolean verifySecurityCode(Long orderId, String securityCode) {
       String encodedSecurityCode = messageRepository.findByOrderId(orderId).getSecurityCode();
        return passwordEncoder.matches(securityCode, encodedSecurityCode);

    }

}
