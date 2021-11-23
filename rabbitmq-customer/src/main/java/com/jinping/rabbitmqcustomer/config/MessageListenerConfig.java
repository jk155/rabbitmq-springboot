package com.jinping.rabbitmqcustomer.config;

import com.jinping.rabbitmqcustomer.Listener.direct.DirectReceiverAck1;
import com.jinping.rabbitmqcustomer.Listener.direct.DirectReceiverAck2;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置 手动ack
 *  手动配置ack有两种方法
 *   1. yml中配置acknowledge-mode: manual(全局转换成手动ack)
 *   2. 写此配置文件 配置中新建SimpleessageListenerContainer
 *       SimpleessageListenerContainer中配置手动确认  配置手动确认的队列 配置监听
 *       配置在同一个SimpleessageListenerContainer钟的队列都会被同一个监听捕获
 *       csdn上常见的方法是在同一个监听类中 通过判断不同的队列来源执行不同业务
 *       容易造成代码冗杂  此次使用的是对每一个队列单独建SimpleessageListenerContainer
 */
@Configuration
public class MessageListenerConfig {
    @Autowired
    private CachingConnectionFactory connectionFactory;
    @Autowired
    private DirectReceiverAck1 directReceiverAck1;
    @Autowired
    private DirectReceiverAck2 directReceiverAck2;


    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息
        //设置一个队列
        container.setQueueNames("TestDirectQueue");
        //告诉代理在单个请求中要向每个消费者发送多少条消息。通常可以将其设置得相当高以提高吞吐量。
        //container.setPrefetchCount();
        container.setMessageListener(directReceiverAck1);

        return container;
    }
    /*@Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer2() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息
        //设置一个队列
        container.setQueueNames("TestDirectQueue1");
        container.setMessageListener(directReceiverAck2);

        return container;
    }*/
}
