package com.qfedu.wc.provider.listener;

import com.alibaba.fastjson.JSON;
import com.qfedu.wc.common.config.RabbitMQQueueConfig;
import com.qfedu.wc.common.config.RedisKeyConfig;
import com.qfedu.wc.common.utils.RedissonUtil;
import com.qfedu.wc.entity.Appointment;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: Stream
 * @date: 2019/11/07 20:30
 * @version: 1.0
 * @description: 预约监听器
 */
@Component
@RabbitListener(queues = RabbitMQQueueConfig.YUYUE_QUEUE)
public class YuyueListener {
    @RabbitHandler
    public void handler(String string) {
        // 新增预约，更新到Redis中
        Appointment appointment = JSON.parseObject (string, Appointment.class);
        RedissonUtil.putHash (RedisKeyConfig.YUYUE_KEY, appointment.getId () + "", string);
    }

}
