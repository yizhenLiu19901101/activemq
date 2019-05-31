package com.zhixuanda.rabbitmq.service;

import com.zhixuanda.rabbitmq.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * exchange有四种类型，分别是headers,direct(默认的),topic,tanout
 */
@Service
public class ProducerService {

    @Autowired
    private AmqpTemplate template;

    public void sendDirectMessage(User user) {
        template.convertAndSend("queueDirect",user);
    }

    public void sendTopicMessage(User user) {
        template.convertAndSend("exchange","topicMessage",user);
    }

    public void sendFanoutMessage(User user) {
        template.convertAndSend("fanoutExchange","",user);
    }
}
