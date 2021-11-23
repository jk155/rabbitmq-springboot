package com.jinping.rabbitmqcustomer.Listener.direct;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiverAck2 implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        System.out.println("Direct2消费");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }
}
