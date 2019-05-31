package com.zhixuanda.rabbitmq.controller;

import com.zhixuanda.rabbitmq.entity.User;
import com.zhixuanda.rabbitmq.service.CustomerService;
import com.zhixuanda.rabbitmq.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class DemoController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProducerService producerService;
    @RequestMapping("/sendDirectMessage")
    public void sendDirectMessage(){
        User user = new User();
        user.setPassword("123");
        user.setUserName("root");
        System.out.println("sender: "+user.toString());
        producerService.sendDirectMessage(user);
    }

    @RequestMapping("/sendTopicMessage")
    public void sendTopic(){
        User user = new User();
        user.setPassword("456");
        user.setUserName("milo");
        System.out.println("sender: "+user.toString());
        producerService.sendTopicMessage(user);
    }

    @RequestMapping("/sendFanoutMessage")
    public void sendFanout(){
        User user = new User();
        user.setPassword("789");
        user.setUserName("jack");
        System.out.println("sender: "+user.toString());
        producerService.sendFanoutMessage(user);
    }

}
