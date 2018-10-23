package com.cn.sk.springcloudstream.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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
@EnableBinding({Sink.class})

public class KafkaConsumerExtentionBean {


    @Autowired
    private Sink sink;

    @Autowired
    @Qualifier(Sink.INPUT)
    private SubscribableChannel subscribableChannel;

    /**
     * 通过实现异步回调的方式获取消息
     */
    @PostConstruct
    public void init(){
        subscribableChannel.subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                Object payload = message.getPayload();
                System.out.println("@PostConstruct注解,subscribableChannel对象,收到的结果 ：" + payload);
            }
        });
    }

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void serviceActivator(Object onmessage){
        System.out.println("@serviceActivator,serviceActivator方法,收到的结果 ：" + onmessage);
    }

    @StreamListener(Sink.INPUT)
    public void streamListener(Object onmessage){
        System.out.println("@StreamListener,streamListener方法,收到的结果 ：" + onmessage);
    }

}
