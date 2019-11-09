package com.qfedu.wc.api.config;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Stream
 * @date: 2019/11/07 12:01
 * @version: 1.0
 * @description: 延长访问时间
 */
@Configuration
public class FeignConfig {
    private int connectTime = 10000;
    private int readTime = 10000;

    @Bean
    public Request.Options createOP() {
        return new Request.Options (connectTime, readTime);
    }

    //Feign 的重试次数 默认重试5次
    @Bean
    public Retryer createR(){
//      return new Retryer.Default();
        return new Retryer.Default(50,100,3);
    }

}
