package com.jinping.rabbitmqcustomer.Listener.direct;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiverAck1 implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        System.out.println("Direct1消费");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        //channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
    }
}
