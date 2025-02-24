package com.pragma.messaging.configuration;




import com.pragma.messaging.adapters.driven.feigns.adapter.UserFeignClientAdapter;
import com.pragma.messaging.adapters.driven.feigns.clients.UserFeignClient;
import com.pragma.messaging.adapters.driven.mongodb.adapters.MessageAdapter;
import com.pragma.messaging.adapters.driven.mongodb.mapper.MessageEntityMapper;
import com.pragma.messaging.adapters.driven.mongodb.repository.MessageRepository;
import com.pragma.messaging.adapters.driven.sendmessage.adapter.SendMessageAdapter;
import com.pragma.messaging.domain.api.MessageServicePort;
import com.pragma.messaging.domain.spi.MessagePersistancePort;
import com.pragma.messaging.domain.spi.SendMessageApiPort;
import com.pragma.messaging.domain.spi.UserFeignClientPort;
import com.pragma.messaging.domain.use_cases.MessageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private  final UserFeignClient userFeignClient;
private final MessageRepository messageRepository;
private final MessageEntityMapper messageEntityMapper;
@Bean
    public UserFeignClientPort userFeignClientPort(){
        return new UserFeignClientAdapter(userFeignClient);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public MessagePersistancePort messagePersistancePort(){
        return new MessageAdapter(encoder(),messageEntityMapper,messageRepository);

    }
    @Bean
    public SendMessageApiPort sendMessageApiPort(){
        return new SendMessageAdapter();
    }
    @Bean
    public MessageServicePort messageServicePort(){
        return new MessageUseCase(userFeignClientPort(),messagePersistancePort(),sendMessageApiPort());
    }
}

