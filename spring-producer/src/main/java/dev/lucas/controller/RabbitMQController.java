package dev.lucas.controller;

import dev.lucas.amqp.AmqpProducer;
import dev.lucas.dto.Message;
import dev.lucas.service.AmqpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitMQController {

    private AmqpProducer<Message> amqpProducer;
    private AmqpService amqpService;

    public RabbitMQController(AmqpProducer<Message> amqpProducer, AmqpService amqpService) {
        this.amqpProducer = amqpProducer;
        this.amqpService = amqpService;
    }

    @PostMapping
    public String post(@RequestBody Message message){
        amqpService.sendToConsumer(message);
        return "OK!";
    }
}
