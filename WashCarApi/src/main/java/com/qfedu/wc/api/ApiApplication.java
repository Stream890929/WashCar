package com.qfedu.wc.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: Stream
 * @date: 2019/11/06 17:25
 * @version: 1.0
 * @description: 消费者服务
 */
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run (ApiApplication.class, args);
    }

}
