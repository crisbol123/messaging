package com.pragma.messaging.adapters.driven.mongodb.mapper;

import com.pragma.messaging.adapters.driven.mongodb.entities.MessageStorage;
import com.pragma.messaging.domain.model.MessageReady;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageEntityMapper {
    MessageStorage toEntity(MessageReady messageReady);
}
