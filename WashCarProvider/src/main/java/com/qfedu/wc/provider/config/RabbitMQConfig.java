package com.qfedu.wc.provider.config;

import com.qfedu.wc.common.config.RabbitMQQueueConfig;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author: Stream
 * @date: 2019/11/07 20:23
 * @version: 1.0
 * @description: RabbitMQ 工具
 */
@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue createQueue() {
        return new Queue (RabbitMQQueueConfig.YUYUE_QUEUE);
    }

    /*@Bean
    public RabbitTemplate createRT() {
        return new RabbitTemplate ();
    }*/

}
