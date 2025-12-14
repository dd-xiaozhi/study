package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author xiaozhi
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/payment/zk")
    public String paymentZK() {
        return "springcloud with consul：" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
