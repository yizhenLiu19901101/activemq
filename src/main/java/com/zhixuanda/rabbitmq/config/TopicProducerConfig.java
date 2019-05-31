package com.zhixuanda.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * topic允许模糊匹配
 */
@Configuration
public class TopicProducerConfig {

    @Bean(name="topicMessage")
    public Queue queueMessage() {
        return new Queue("topicMessage");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    public Binding bindingExchangeMessage(@Qualifier("topicMessage") Queue queueMessage, TopicExchange exchange) {
        //*表示一个词,#表示零个或多个词
        //return BindingBuilder.bind(queueMessage).to(exchange).with("topicMessage");
        return BindingBuilder.bind(queueMessage).to(exchange).with("#");
    }
}
