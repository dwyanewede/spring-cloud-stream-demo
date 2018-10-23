package com.cn.sk.springcloudstream.kafka.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @ProjectName: spring-cloud-stream-kafka
 * @Package: com.sk.cn.springcloudstreamkafkademo.stream.messaging
 * @ClassName: MessageSource
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/10/22 11:41
 * @UpdateDate: 2018/10/22 11:41
 * @Version: 1.0
 */
public interface MessageSource {
    String TESTOUTPUT = "test";

    @Output(MessageSource.TESTOUTPUT)
    MessageChannel output();
}
