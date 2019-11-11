package com.qfedu.wc.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: Stream
 * @date: 2019/11/09 08:06
 * @version: 1.0
 * @description: 统一网关中心
 */
@EnableDiscoveryClient
@EnableHystrixDashboard  //启用监控仪表盘
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run (ZuulApplication.class, args);
    }
}
