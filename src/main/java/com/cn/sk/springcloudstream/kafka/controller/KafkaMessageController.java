package com.cn.sk.springcloudstream.kafka.controller;

import com.cn.sk.springcloudstream.kafka.provider.KafkaProviderBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: spring-cloud-stream-demo
 * @Package: com.cn.sk.springcloudstream.rabbit.controller
 * @ClassName: MessageController
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/10/22 17:12
 * @UpdateDate: 2018/10/22 17:12
 * @Version: 1.0
 */
@RestController
public class KafkaMessageController {

    private final KafkaProviderBean kafkaProviderBean;

    @Autowired
    public KafkaMessageController(KafkaProviderBean kafkaProviderBean) {
        this.kafkaProviderBean = kafkaProviderBean;
    }

    @PostMapping("/send/kafka/msg")
    public boolean sendMsg(@RequestParam String msg) {
        kafkaProviderBean.sendMsg(msg);
        return true;
    }

    // 测试方法 测试 KafkaproviderExtentionBean中相应的方法 #sendSource #sendMessageSource
}
