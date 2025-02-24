package com.pragma.messaging.adapters.driven.mongodb.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageStorage {
    private Long clientId;
    private Long orderId;
    private String phoneNumber;
    private String securityCode;
}
