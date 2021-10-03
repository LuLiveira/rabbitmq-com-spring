package dev.lucas.service.impl;

import dev.lucas.dto.Message;
import dev.lucas.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumerService implements ConsumerService<Message> {

    @Override
    public void executar(Message message) {
        System.out.println(message);
    }
}
