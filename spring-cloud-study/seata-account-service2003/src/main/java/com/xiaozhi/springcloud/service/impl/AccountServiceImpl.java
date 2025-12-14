package com.xiaozhi.springcloud.service.impl;

import com.xiaozhi.springcloud.mapper.AccountMapper;
import com.xiaozhi.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author xiaozhi
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        // try {
        //     TimeUnit.SECONDS.sleep(20);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        accountMapper.decrease(userId, money);
        log.info("======执行扣减金额操作======");
    }
}
