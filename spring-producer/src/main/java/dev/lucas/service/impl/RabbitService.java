package dev.lucas.service.impl;

import dev.lucas.amqp.AmqpProducer;
import dev.lucas.dto.Message;
import dev.lucas.service.AmqpService;
import org.springframework.stereotype.Service;

@Service
public class RabbitService implements AmqpService {

    private AmqpProducer<Message> rabbitProducer;

    public RabbitService(AmqpProducer<Message> rabbitProducer) {
        this.rabbitProducer = rabbitProducer;
    }

    @Override
    public void sendToConsumer(Message message) {
        rabbitProducer.producer(message);
    }
}
