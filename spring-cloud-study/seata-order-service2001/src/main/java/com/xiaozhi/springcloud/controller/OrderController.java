package com.xiaozhi.springcloud.controller;

import com.xiaozhi.springcloud.domain.CommonResult;
import com.xiaozhi.springcloud.domain.Order;
import com.xiaozhi.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaozhi
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("addOrder")
    public CommonResult createOrder(Order order) {
        orderService.createOrder(order);
        return new CommonResult(200, "成功创建订单~~~");
    }
}
