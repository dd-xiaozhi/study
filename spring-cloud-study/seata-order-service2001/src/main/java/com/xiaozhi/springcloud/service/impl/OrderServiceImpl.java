package com.xiaozhi.springcloud.service.impl;

import com.xiaozhi.springcloud.domain.Order;
import com.xiaozhi.springcloud.mapper.OrderMapper;
import com.xiaozhi.springcloud.service.AccountService;
import com.xiaozhi.springcloud.service.OrderService;
import com.xiaozhi.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiaozhi
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @GlobalTransactional(name = "fsp-create-orde", rollbackFor = Exception.class)
    @Override
    public void createOrder(Order order) {
        log.info("======= 创建订单开始 ======");
        orderMapper.create(order);
        log.info("======= 远程调用扣减库存开始 ======");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("======= 远程调用扣减库存结束 ======");

        log.info("======= 远程调用扣减金额开始 ======");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("======= 远程调用扣减金额结束 ======");

        log.info("======= 修改订单状态开始 ======");
        orderMapper.update(order.getUserId(), 1);
        log.info("======= 修改订单状态结束 ======");
        log.info("======= 下单结束 ======");
    }
}
