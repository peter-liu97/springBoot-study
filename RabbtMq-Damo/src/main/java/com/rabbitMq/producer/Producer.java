package com.rabbitMq.producer;

import com.rabbitMq.utill.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Producer {
    public static void getMessage() throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                System.out.println(new String(body,"utf-8"));
            }
        };
        channel.basicConsume(ConnectionUtil.QUEUE_NAME,consumer);
    }

    public static void main(String[] args) throws Exception {
        getMessage();
    }
}
