package com.jinping.rabbitmqproducer.controller;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 */
@RestController
public class TestController {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @RequestMapping("directConfirmTest")
    public void directConfirmTest(){
        rabbitTemplate.convertAndSend("TestDirectExchange","info","Direct Message",new CorrelationData());
    }
    @RequestMapping("directReturnTest")
    public void directReturnTest(){
        rabbitTemplate.convertAndSend("TestDirectExchange","return","Direct Message",new CorrelationData());
    }
}
