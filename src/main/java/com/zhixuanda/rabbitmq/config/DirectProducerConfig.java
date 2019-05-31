package com.zhixuanda.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * direct需要精确匹配
 */
@Configuration
public class DirectProducerConfig {
    /**
     * direct模式
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue("queueDirect");
    }
}
