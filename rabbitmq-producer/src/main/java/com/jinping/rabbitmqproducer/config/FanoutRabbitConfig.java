package com.jinping.rabbitmqproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {
    @Bean
    public Queue queueA(){
        return new Queue("TestFanoutQueueA",true);
    }
    @Bean
    public Queue queueB(){
        return new Queue("TestFanoutQueueB",true);
    }
    @Bean
    public Queue queueC(){
        return new Queue("TestFanoutQueueC",true);
    }
    @Bean
    public FanoutExchange TestFanoutExchange(){
        return new FanoutExchange("TestFanoutExchange",true,false);
    }
    @Bean
    Binding bindingExchangeA(){
        return BindingBuilder.bind(queueA()).to(TestFanoutExchange());
    }
    @Bean
    Binding bindingExchangeB(){
        return BindingBuilder.bind(queueB()).to(TestFanoutExchange());
    }
    @Bean
    Binding bindingExchangeC(){
        return BindingBuilder.bind(queueC()).to(TestFanoutExchange());
    }
}
