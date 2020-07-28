package com.rabbitMq.run;

import com.rabbitMq.consumer.Consumer;
import com.rabbitMq.producer.Producer;

public class test {
    public static void main(String[] args) throws Exception {
        while (true){
            Consumer.sendByExchange("hello");
            Thread.sleep(1000);
        }

//        Producer.getMessage();
    }
}
