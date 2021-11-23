package com.jinping.rabbitmqcustomer.config;

import com.jinping.rabbitmqcustomer.Listener.DirectReceiverAck1;
import com.jinping.rabbitmqcustomer.Listener.DirectReceiverAck2;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListenerConfig {
    @Autowired
    private CachingConnectionFactory connectionFactory;
    @Autowired
    private DirectReceiverAck1 directReceiverAck1;
    @Autowired
    private DirectReceiverAck2 directReceiverAck2;
//消息接收处理类

    private String queueName = "TestDirectQueue";


    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息
        //设置一个队列
        container.setQueueNames("TestDirectQueue");
        container.setMessageListener(directReceiverAck1);

        return container;
    }
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer2() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息
        //设置一个队列
        container.setQueueNames("TestDirectQueue1");
        container.setMessageListener(directReceiverAck2);

        return container;
    }
}
