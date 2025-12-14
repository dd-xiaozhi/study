package com.atguigu.springcloud.service;

import com.atguigu.springcloud.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xiaozhi
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/getPaymentById")
    CommonResult getPaymentById(@RequestParam("id") Long id);


    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeOut();
}
