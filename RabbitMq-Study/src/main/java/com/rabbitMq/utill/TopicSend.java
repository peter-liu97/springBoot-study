package com.rabbitMq.utill;


import com.rabbitMq.exChange.DirectRabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Component
public class TopicSend implements RabbitTemplate.ConfirmCallback , RabbitTemplate.ReturnCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg){
        rabbitTemplate.setConfirmCallback(this);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("发送的消息为"+msg);
        this.rabbitTemplate.convertAndSend(DirectRabbitConfig.EXCHANGE_NAME,"topic",msg,correlationData);
    }




    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

        System.out.println("消息id:" + correlationData.getId());
        if (ack) {
            System.out.println("消息发送确认成功");
        } else {
            System.out.println("消息发送确认失败:" + cause);
        }
    }

    /**
     * 如果消息没有到exchange,则confirm回调,ack=false
     * 如果消息到达exchange,则confirm回调,ack=true
     * exchange到queue成功,则不回调return
     * exchange到queue失败,则回调return
     */

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {

        try {
            System.out.println("return--message:" + new String(message.getBody(), "UTF-8") + ",replyCode:" + replyCode
                    + ",replyText:" + replyText + ",exchange:" + exchange + ",routingKey:" + routingKey);
        } catch (UnsupportedEncodingException e) {
        }
    }
}
