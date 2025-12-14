package com.xiaozhi.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xiaozhi
 */
@Service
@Slf4j
public class OrderService {

    @SentinelResource("getOrder")
    public void getOrder() {
        log.info("访问getOrder");
    }

    public static void main(String[] args) {
        System.out.println(0x6666);
    }
}
