package com.qfedu.wc.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author: Stream
 * @date: 2019/11/06 16:56
 * @version: 1.0
 * @description: 服务提供者开关
 */
@EnableCircuitBreaker  //启用Hystrix，监控
@EnableHystrix
@EnableDiscoveryClient
@EntityScan(basePackages = "com.qfedu.wc.entity")
@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run (ProviderApplication.class, args);
    }

}
