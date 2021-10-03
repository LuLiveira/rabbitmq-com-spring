package dev.lucas.amqp.impl;

import dev.lucas.amqp.AmqpConsumer;
import dev.lucas.dto.Message;
import dev.lucas.service.ConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer implements AmqpConsumer<Message> {

    private ConsumerService<Message> service;

    public RabbitMQConsumer(ConsumerService<Message> service) {
        this.service = service;
    }

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consume(Message message) {
        service.executar(message);
    }
}
