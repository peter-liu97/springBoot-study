package com.rabbitMq.exChange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {
    public final static String man = "topic.man";
    public final static String woman = "topic.woman";

    @Bean
    public Queue fristQueue(){
        return new Queue(TopicRabbitConfig.man);
    }
    @Bean
    public Queue secondQueue(){
        return new Queue(TopicRabbitConfig.woman);
    }
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    Binding bindingExchangeMessageOfMan(){
        return BindingBuilder.bind(fristQueue()).to(exchange()).with(man);
    }

    @Bean
    Binding bindingExchangeMessageOfWoman(){
        return BindingBuilder.bind(secondQueue()).to(exchange()).with(woman);
    }
    @Bean
    Binding bindingExchangeMessage(){
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.*");
    }



}
