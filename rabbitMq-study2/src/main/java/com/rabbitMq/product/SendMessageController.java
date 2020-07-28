package com.rabbitMq.product;

import com.rabbitMq.utill.TopicSend;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class SendMessageController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    TopicSend topicSend;


    @GetMapping("/sendMessage")
    public String sendMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        topicSend.send(messageId);
        return "ok";
    }

}
