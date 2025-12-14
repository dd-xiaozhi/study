package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PayService;
import com.atguigu.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaozhi
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PayService payService;

    @Value("${server.port}")
    private Integer serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discovery")
    public DiscoveryClient getDiscovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost()
                    + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("lb")
    public String lb(HttpServletRequest request) {
        String header = request.getHeader("X-Request-Id");
        if (header == null) {
            header = "";
        }
        return serverPort.toString() + "---" + header;
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

    @GetMapping("/zipkin")
    public String paymentZipkin() {
        return "hi ,I am xiaozhi";
    }

}
