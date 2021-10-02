package dev.lucas.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ProducerRabbitConfiguration {

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.request.deadletter.producer}")
    private String deadLetter;

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue deadLetter(){
        return new Queue(deadLetter);
    }

    @Bean
    public Queue queue(){
        Map<String, Object> properties = Map.of("x-dead-letter-exchange", exchange, "x-dead-letter-routing-key", deadLetter);
        return new Queue(queue, true, false, false, properties);
    }

    @Bean
    public Binding bindingQueue(){
        return BindingBuilder.bind(queue()).to(directExchange()).with(queue);
    }

    @Bean
    public Binding bindingDeadLetter(){
        return BindingBuilder.bind(deadLetter()).to(directExchange()).with(deadLetter);
    }
}
