package com.algaworks.algasensors.temperature.monitoring.infrastructure.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.JacksonJavaTypeMapper;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.json.JsonMapper;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "temperature-monitoring.process-temperature.v1.q";

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public Queue queue(){
        return QueueBuilder.durable(QUEUE).build();
    }


    @Bean
    public FanoutExchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange("temperature-processing.temperature-recived.v1.e")
                .build();
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(fanoutExchange());
    }

    @Bean
    public MessageConverter messageConverter(JsonMapper jsonMapper){
        return new JacksonJsonMessageConverter(jsonMapper);
    }
}
