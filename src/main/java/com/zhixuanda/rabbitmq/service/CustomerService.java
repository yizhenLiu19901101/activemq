package com.zhixuanda.rabbitmq.service;

import com.zhixuanda.rabbitmq.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    //日志组件
    private Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private Environment environment;

    //监听器监听指定的Queue
    @RabbitListener(queues="queueDirect")
    public void receiveDirectMessage(User user) {
        logger.info("port " + environment.getProperty("server.port") + " receive message by direct:"+user.toString());
    }

    //监听器监听指定的Queue
    @RabbitListener(queues="topicMessage")
    public void receiveTopicMessage(User user) {
        logger.info("port " + environment.getProperty("server.port") + " receive message by topic:"+user.toString());
    }

    @RabbitListener(queues="fanout.A")
    public void processA(User user) {
        logger.info("port " + environment.getProperty("server.port") + " receive message by fanout.A:"+user.toString());
    }

    @RabbitListener(queues="fanout.B")
    public void processB(User user) {
        logger.info("port " + environment.getProperty("server.port") + " receive message by fanout.B:"+user.toString());
    }
}
