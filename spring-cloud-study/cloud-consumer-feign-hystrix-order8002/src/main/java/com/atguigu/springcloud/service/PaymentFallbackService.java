package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author xiaozhi
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务调用失败，提示来自：" +
                "cloud-consumer-feign-order8002#paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务调用失败，提示来自：" +
                "cloud-consumer-feign-order8002#paymentInfo_TimeOut";
    }
}
