package com.jinping.rabbitmqproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue firstQueue(){
        return new Queue("TopicFirstQueue",true);
    }
    @Bean
    public Queue secondQueue(){
        return new Queue("TopicSecondQueue",true);
    }
    @Bean
    public TopicExchange TestTopicExchange(){
        return new TopicExchange("TestTopicExchange",true,false);
    }
    @Bean
    public Binding bindTopic(){
        return BindingBuilder.bind(firstQueue()).to(TestTopicExchange()).with("topic.#");
    }
    @Bean
    public Binding bindTopic1(){
        return BindingBuilder.bind(secondQueue()).to(TestTopicExchange()).with("topic.*");
    }
}
