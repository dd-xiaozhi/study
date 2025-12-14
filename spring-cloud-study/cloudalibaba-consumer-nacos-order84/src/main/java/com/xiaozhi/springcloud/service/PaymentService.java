package com.xiaozhi.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author XIAOZHI
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)// 调用中关闭9003服务提供者
public interface PaymentService {
    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}