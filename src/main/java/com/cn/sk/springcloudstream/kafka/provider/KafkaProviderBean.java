package com.cn.sk.springcloudstream.kafka.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;


@Component
public class KafkaProviderBean {

    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public KafkaProviderBean(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMsg(String msg) {
        System.out.println("生产者发送的消息是： " + msg);
        kafkaTemplate.send("someTopic", msg);
    }


}