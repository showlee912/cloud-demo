package com.showlee.order.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderConfig {

//    //开启超时重试
//    @Bean
//    Retryer retryer() {
//        return new Retryer.Default();
//    }

    //开启Openfeign的日志
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @LoadBalanced //注解式负载均衡
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
