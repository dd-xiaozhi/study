package com.xiaozhi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiaozhi
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients     // 开启Feign支持
public class OrderNacosMain84 {
    public static void main(String[] args) {
            SpringApplication.run(OrderNacosMain84.class, args);
    }
}
