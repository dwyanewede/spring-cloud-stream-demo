package com.cn.sk.springcloudstream.rabbit.provider;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyProducerBean {

    private final AmqpAdmin amqpAdmin;
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public MyProducerBean(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMsg(String msg) {
        System.out.println("生产者发送的消息是： " + msg);
        amqpTemplate.convertAndSend("queue", msg);
    }

    public void sendExchange(String msg) {
        System.out.println("生产者发送的消息是： " + msg);
        amqpTemplate.convertAndSend("exchange","topic.message", msg + "  topic.message");
        amqpTemplate.convertAndSend("exchange","topic.messages", msg + "  topic.messages");
    }

    public void sendFanout(String msg) {
        System.out.println("生产者发送的消息是： " + msg);
        amqpTemplate.convertAndSend("fanoutExchange","", msg + "  A");
        amqpTemplate.convertAndSend("fanoutExchange","", msg + "  B");
        amqpTemplate.convertAndSend("fanoutExchange","", msg + "  C");
    }

}