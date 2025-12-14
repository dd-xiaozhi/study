package com.xiaozhi.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xiaozhi.springcloud.handle.BlockHandlerMethod;
import com.xiaozhi.springcloud.handle.FallbackMethod;
import com.xiaozhi.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaozhi
 */
@RestController
@Slf4j
public class FlowLimitController {

    @Resource
    private OrderService orderService;

    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        orderService.getOrder();
        // TimeUnit.SECONDS.sleep(1);
        // int a = 1 / 0;
        return "-------TestA------";
    }

    @GetMapping("/testB")
    public String testB() {
        orderService.getOrder();
        return "-------TestB------";
    }

    @GetMapping("/testC")
    @SentinelResource(value = "testC")
    public String testC(@RequestParam(name = "p1", required = false) String p1,
                        @RequestParam(name = "p2", required = false) String p2) {
        System.out.println("P1：" + p1 + "，P2：" + p2);
        return "testC--------------";
    }



    @GetMapping("/testD")
    @SentinelResource(value = "testD",
            blockHandlerClass = BlockHandlerMethod.class, blockHandler = "returnMethod01",
            fallbackClass = FallbackMethod.class, fallback = "fallbackMethod01",
            exceptionsToIgnore = ArithmeticException.class)
    public String testD() {
        int i = 10 / 0;
        return "testD--------------";
    }

    // 超出阈值兜底方法，它不能为private!!!
    // public String blockHandlerMethod(BlockException ex) {
    //     return "return blockHandlerMethod";
    // }

    // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    // public static String fallbackMethod01(Throwable ex) {
    //     return "fallbackMethod01 Method";
    // }

}
