package com.qfedu.wc.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: Stream
 * @date: 2019/11/06 18:16
 * @version: 1.0
 * @description: 注册中心
 */
@EnableEurekaServer
@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run (ServerApplication.class, args);
    }

}
