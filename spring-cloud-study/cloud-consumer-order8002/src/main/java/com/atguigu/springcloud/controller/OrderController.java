package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import com.atguigu.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author xiaozhi
 */
@RestController
@Slf4j
@RequestMapping("order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    public static final String PaymentSrv_URL = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/addOrder")
    public CommonResult addPayment(Payment payment) {
        return restTemplate.postForObject(PaymentSrv_URL + "/payment/add",
                payment, CommonResult.class);
    }

    @GetMapping("/getOrderById")
    public CommonResult getPaymentById(@RequestParam("id") Long id) {
        System.out.println("");
        return restTemplate.getForObject(PaymentSrv_URL + "/payment/getPaymentById?id=" + id,
                CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance serviceInstance = loadBalancer.instance(instances);
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }

}