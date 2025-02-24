package com.pragma.messaging.adapters.driving.http.controller;

import com.pragma.messaging.adapters.driving.http.dto.request.SendMessageDTO;
import com.pragma.messaging.adapters.driving.http.mapper.MessageRequestMapper;
import com.pragma.messaging.domain.api.MessageServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.pragma.messaging.configuration.Constants.*;

@RestController
@AllArgsConstructor
@RequestMapping(MESSAGE_BASE_PATH)
@Tag(name = MESSAGE_TAG, description = MESSAGE_DESCRIPTION)
public class MessageRequestController {
    private final MessageServicePort messageServicePort;
    private final MessageRequestMapper messageRequestMapper;

    @PostMapping(MESSAGE_SEND_READY_PATH)
    @Operation(summary = MESSAGE_SEND_READY_SUMMARY, description = MESSAGE_SEND_READY_DESCRIPTION)
    public void sendMessageReady(@RequestBody SendMessageDTO sendMessageDTO) {
        messageServicePort.sendMessageReady(messageRequestMapper.toDomainReady(sendMessageDTO));
    }

    @PostMapping(MESSAGE_SEND_CANCELED_PATH)
    @Operation(summary = MESSAGE_SEND_CANCELED_SUMMARY, description = MESSAGE_SEND_CANCELED_DESCRIPTION)
    public void sendMessageCanceled(@RequestBody SendMessageDTO sendMessageDTO) {
        messageServicePort.sendMessageCanceled(messageRequestMapper.toDomainCancel(sendMessageDTO));
    }

    @GetMapping(MESSAGE_VERIFY_SECURITY_CODE_PATH)
    @Operation(summary = MESSAGE_VERIFY_SECURITY_CODE_SUMMARY, description = MESSAGE_VERIFY_SECURITY_CODE_DESCRIPTION)
    public boolean verifySecurityCode(@RequestParam(ORDER_ID_PARAM) Long orderId, @RequestParam(SECURITY_CODE_PARAM) String securityCode) {
        return messageServicePort.verifySecurityCode(securityCode, orderId);
    }
}
