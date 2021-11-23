package com.jinping.rabbitmqcustomer.Listener.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver {
    @RabbitListener(queues = "TopicFirstQueue")
    public void listener1(String message){
        System.out.println("listener1: "+message);
    }
    @RabbitListener(queues = "TopicSecondQueue")
    public void listener2(String message){
        System.out.println("listener2: "+message);
    }
}
