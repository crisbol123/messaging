package com.pragma.messaging.domain.spi;


import com.pragma.messaging.adapters.driven.feigns.dto.AuthorizationResponse;

public interface UserFeignClientPort {

    AuthorizationResponse validateToken(String token);
    String getPhoneNumber(Long clientId);
}
