package com.jinping.rabbitmqproducer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqProducerApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    public void test1(){
        rabbitTemplate.convertAndSend("TestDirectExchange","info","Direct Message");
    }

}
