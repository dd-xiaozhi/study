package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PayService;
import com.atguigu.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaozhi
 */
@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {

    @Resource
    private PayService payService;

    @Value("${server.port}")
    private Integer serverPort;

    @PostMapping("/add")
    public CommonResult addPayment(@RequestBody Payment payment) {
        int res = payService.create(payment);
        log.info("插入结果为 --- {}", res);
        if (res > 0) {
            return new CommonResult(200, "添加成功，prot：" + serverPort, res);
        } else {
            return new CommonResult(444, "添加失败");
        }
    }

    @GetMapping("/getPaymentById")
    public CommonResult getPaymentById(@RequestParam("id") Long id) {
        Payment payment = payService.getPaymentById(id);
        log.info("查询结果为 --- {}", payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功 - port：" + serverPort, payment);
        } else {
            return new CommonResult(444, "查询失败");
        }
    }

    @GetMapping("lb")
    public String lb() {
        return serverPort.toString();
    }

    @GetMapping("/feign/timeout")
    public String timeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return serverPort.toString();
    }
}
