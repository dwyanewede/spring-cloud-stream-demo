package com.cn.sk.springcloudstream.kafka.provider;
import com.cn.sk.springcloudstream.kafka.messaging.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.*;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @ProjectName: spring-cloud-stream-kafka
 * @Package: com.sk.cn.springcloudstreamkafkademo.stream.consumer
 * @ClassName: MessageConsumerBean
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/10/22 12:59
 * @UpdateDate: 2018/10/22 12:59
 * @Version: 1.0
 */

@Component
@EnableBinding({Source.class, MessageSource.class})
public class KafkaproviderExtentionBean {

    @Autowired
    private Source source;

    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel messageChannel;

    @Autowired
    private MessageSource messageSource;


    /**
     * messageChannel 发送新消息
     *
     * @param message
     */
    public void sendChannel(String message) {
        // 通过消息管道发送消息
        messageChannel.send(MessageBuilder.withPayload(message).build());
    }

    /**
     * messageSource 发送新消息
     *
     * @param message
     */
    public void sendSource(String message) {
        // 通过消息管道发送消息
//        source.output().send(MessageBuilder.withPayload(message).build());
        source.output().send(new GenericMessage(message, new HashMap<String, Object>()));

    }

    /**
     * myMessageChannel 自定义消息处理器 发送新消息
     *
     * @param message
     */
    public void sendMessageSource(String message) {
        // 通过消息管道发送消息
        messageSource.output().send(MessageBuilder.withPayload(message).build());
    }
}