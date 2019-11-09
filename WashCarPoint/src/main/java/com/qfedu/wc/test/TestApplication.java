package com.qfedu.wc.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author: Stream
 * @date: 2019/11/08 07:44
 * @version: 1.0
 * @description: 测试,定时任务
 */
@EnableScheduling
@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run (TestApplication.class, args);
    }
}
