package dev.lucas.service;

import dev.lucas.dto.Message;

public interface AmqpService {
    void sendToConsumer(Message message);
}
