package com.jinping.rabbitmqcustomer.Listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DirectReceiver {

    //监听的队列名称
    @RabbitListener(queues = "TestDirectQueue")
    public void process(Channel channel, Message message) throws IOException, InterruptedException {
        System.out.println("DirectListener接受到的消息:"+new String(message.getBody()));
        channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
    }
}
