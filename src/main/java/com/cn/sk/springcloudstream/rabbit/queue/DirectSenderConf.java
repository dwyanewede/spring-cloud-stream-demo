package com.cn.sk.springcloudstream.rabbit.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * rabbitmq直连
 */
//@Configuration
public class DirectSenderConf {
     @Bean
     public Queue queue1() {
          return new Queue("queue");
     }
}
