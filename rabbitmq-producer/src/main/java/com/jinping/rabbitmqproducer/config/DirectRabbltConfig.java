package com.jinping.rabbitmqproducer.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 直连
 */
@Configuration
public class DirectRabbltConfig {
    /**
     * 定义队列
     * @return
     */
    @Bean
    public Queue TestDirectQueue(){
        return new Queue("TestDirectQueue",true);
    }
    @Bean
    public Queue TestDirectQueue1() {
        return new Queue("TestDirectQueue1",true);
    }

    /**
     * 定义直连交换机
     * @return
     */
    @Bean
    public DirectExchange TestDirectExchange(){
        return new DirectExchange("TestDirectExchange",true,false);
    }

    /**
     * 绑定关系
     * @return
     */
    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("info");
    }
    @Bean
    public Binding bindingDirect1(){
        return BindingBuilder.bind(TestDirectQueue1()).to(TestDirectExchange()).with("info");
    }
}
