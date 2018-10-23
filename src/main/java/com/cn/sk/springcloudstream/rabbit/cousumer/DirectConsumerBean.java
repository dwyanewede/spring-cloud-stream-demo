package com.cn.sk.springcloudstream.rabbit.cousumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectConsumerBean {

	@RabbitListener(queues = "queue")
	public void processMessage(String content) {
		System.out.println("消费端收到的消息是： " + content);
	}

}