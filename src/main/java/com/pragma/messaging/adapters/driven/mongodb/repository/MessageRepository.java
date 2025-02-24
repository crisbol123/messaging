package com.pragma.messaging.adapters.driven.mongodb.repository;

import com.pragma.messaging.adapters.driven.mongodb.entities.MessageStorage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<MessageStorage, String> {
MessageStorage findByOrderId(Long orderId);
}
