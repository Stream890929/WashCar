package com.qfedu.wc.api.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Stream
 * @date: 2019/11/08 21:45
 * @version: 1.0
 * @description:
 */
@Configuration
public class RibbonConfig {
    // 1.创建工具类对象，负载均衡
    @Bean
    @LoadBalanced
    public RestTemplate createRT(){
        return new RestTemplate();
    }

    // 2.创建对应的负载均衡算法-分发策略
    @Bean
    public IRule createRule(){
        //return new RandomRule();//随机分发
//        return new ZoneAvoidanceRule();//区域感知 就近原则
//        return new BestAvailableRule();//并发量小的优先分配
//        return new WeightedResponseTimeRule();//权重分发
        //轮询
        return new RoundRobinRule ();
    }
}
