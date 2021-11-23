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
    public void directTest(){
        rabbitTemplate.convertAndSend("TestDirectExchange","info","Direct Message");
    }
    @Test
    public void topicTest(){
        rabbitTemplate.convertAndSend("TestTopicExchange","topic.info","Topic Message: routingKey: topic.info");
        rabbitTemplate.convertAndSend("TestTopicExchange","topic.info.info","Topic Message: routingKey: topic.info.info");
    }
    @Test
    public void FanoutTest(){
        rabbitTemplate.convertAndSend("TestFanoutExchange",null,"Fanout Message");
    }

}
