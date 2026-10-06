
package com.algaworks.algasensors.temperature.monitoring.infrastructure.rabbitmq;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMQInitializer {
    private final RabbitAdmin admin;

    @PostConstruct
    public void init(){
        admin.initialize();
    }
}
