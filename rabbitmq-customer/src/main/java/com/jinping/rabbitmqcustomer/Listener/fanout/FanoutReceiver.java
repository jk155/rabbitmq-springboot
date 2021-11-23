package com.jinping.rabbitmqcustomer.Listener.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {
    @RabbitListener(queues = "TestFanoutQueueA")
    public void listener1(String message){
        System.out.println("listener1: "+message);
    }
    @RabbitListener(queues = "TestFanoutQueueB")
    public void listener2(String message){
        System.out.println("listener2: "+message);
    }
    @RabbitListener(queues = "TestFanoutQueueC")
    public void listener3(String message){
        System.out.println("listener3: "+message);
    }
}
