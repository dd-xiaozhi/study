package com.xiaozhi.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.utils.CommonResult;
import com.xiaozhi.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaozhi
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
        if (id.equals(4L)) {
            throw new IllegalArgumentException("没有该id");
        }
        return paymentService.paymentSql(id);
    }
}
