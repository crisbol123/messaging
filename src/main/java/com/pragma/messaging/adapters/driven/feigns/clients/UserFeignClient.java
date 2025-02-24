package com.pragma.messaging.adapters.driven.feigns.clients;





import com.pragma.messaging.adapters.driven.feigns.FeignClientConfig;
import com.pragma.messaging.adapters.driven.feigns.dto.AuthorizationRequest;
import com.pragma.messaging.adapters.driven.feigns.dto.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user", url = "${usuario.service.url}", configuration = FeignClientConfig.class)
public interface UserFeignClient {


    @GetMapping("/auth-user/validate-token")
    AuthorizationResponse validateToken(@RequestBody AuthorizationRequest authorizationRequest);

    @GetMapping("/user/get-phone-number")
    String getPhoneNumber(@RequestParam Long clientId);
}