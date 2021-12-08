package com.jinping.rabbitmqproducer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * RabbitTemplate.ConfirmCallback 是否发送到交换机 无论是否发送到交换机都会得到返回信息
 * RabbitTemplate.ReturnsCallback 消息是否被路由到队列  只在没有路由到的情况返回信息
 */
@Slf4j
@Component
public class MyConfirmCallback implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnsCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PostConstruct
    public void initRabbitTemplate() {
        log.info("向rabbitTemplate中加入ConfirmCallback的实现");
        // 设置生产者消息确认
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }



    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if(ack){
            log.info("消息id:{} 成功发布到交换机",correlationData.getId());
        }else{
            log.info("消息id:{} 发布到交换机失败 cause:{}",correlationData.getId(),cause);
        }
    }

    @Override
    public void returnedMessage(ReturnedMessage returned) {
        log.info("消息发送到队列失败 返回信息 :{}",returned.toString());
    }
}
