package com.qfedu.wc.provider.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Stream
 * @date: 2019/11/11 17:20
 * @version: 1.0
 * @description:
 */
@Configuration
public class HystrixConfig {
    @Bean
    public ServletRegistrationBean createRB(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean ();
        registrationBean.setServlet (new HystrixMetricsStreamServlet ());
        registrationBean.addUrlMappings ("/hystrix.stream");
        return registrationBean;
    }
}
