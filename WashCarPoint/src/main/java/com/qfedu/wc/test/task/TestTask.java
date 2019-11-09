package com.qfedu.wc.test.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author: Stream
 * @date: 2019/11/08 07:55
 * @version: 1.0
 * @description:
 */
@Component
public class TestTask {
    @Scheduled(cron = "5/5 * 7 * * ?")
    public void speak(){
        System.out.println ("定时任务："+System.currentTimeMillis ()/1000);
    }

    // 每分钟执行一次
    @Scheduled(cron = "0 * * * * ?")
    public void pingJia(){
        System.out.println ("默认评价："+System.currentTimeMillis ()/1000);
    }
}
