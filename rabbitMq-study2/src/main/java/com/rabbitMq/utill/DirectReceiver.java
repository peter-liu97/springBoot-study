package com.rabbitMq.utill;


import com.rabbitMq.config.DirectRabbitConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 消息接受监听类
 */
@Component

public class DirectReceiver {

    @RabbitHandler
    @RabbitListener(queues = "testQueue",containerFactory="rabbitListenerContainerFactory")
    public void process(Message message, Channel channel) throws IOException {

        try {
            //关闭自动确认机制
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("接受到的消息为"+new String(message.getBody(),"UTF-8"));
        } catch (IOException e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
        }
    }
}
