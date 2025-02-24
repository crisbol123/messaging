package com.pragma.messaging.adapters.driving.http.mapper;

import com.pragma.messaging.adapters.driving.http.dto.request.SendMessageDTO;
import com.pragma.messaging.domain.model.MessageCancel;
import com.pragma.messaging.domain.model.MessageReady;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageRequestMapper {
    MessageReady toDomainReady(SendMessageDTO sendMessageDTO);

    MessageCancel toDomainCancel(SendMessageDTO sendMessageDTO);
}
