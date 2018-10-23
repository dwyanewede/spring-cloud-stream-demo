package com.cn.sk.springcloudstream.rabbit.controller;

import com.cn.sk.springcloudstream.rabbit.provider.MyProducerBean;
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
public class RabbitMessageController {

    private final MyProducerBean myProducerBean;

    public RabbitMessageController(MyProducerBean myProducerBean) {
        this.myProducerBean = myProducerBean;
    }

    @PostMapping("/send/rabbit/msg")
    public boolean sendMsg(@RequestParam String msg){
        //直连发送
//        myProducerBean.sendMsg(msg);
        //发送给不同的监听队列
//        myProducerBean.sendExchange(msg);
        //广播式消息发送
        myProducerBean.sendFanout(msg);
        return true;
    }

}
