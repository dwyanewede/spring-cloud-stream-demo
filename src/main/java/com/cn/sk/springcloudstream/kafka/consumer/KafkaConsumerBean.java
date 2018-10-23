package com.cn.sk.springcloudstream.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerBean {

	@KafkaListener(topics = "someTopic")
	public void processMessage(String content) {
		System.out.println("消费端收到的消息是： " + content);
	}

}