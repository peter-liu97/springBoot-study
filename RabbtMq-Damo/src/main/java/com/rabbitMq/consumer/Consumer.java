package com.rabbitMq.consumer;

import com.rabbitMq.utill.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Consumer {
    public static void sendByExchange(String message) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(ConnectionUtil.QUEUE_NAME,true,false,false,null);
        //声明交换机
        channel.exchangeDeclare(ConnectionUtil.EXCHANGE_NAME,"fanout");
        //交换机和队列绑定
        channel.queueBind(ConnectionUtil.QUEUE_NAME,ConnectionUtil.EXCHANGE_NAME,"");

        channel.basicPublish(ConnectionUtil.EXCHANGE_NAME,"",null,message.getBytes());
        System.out.println("发送的消息为:"+message);
        channel.close();
        connection.close();
    }
}
