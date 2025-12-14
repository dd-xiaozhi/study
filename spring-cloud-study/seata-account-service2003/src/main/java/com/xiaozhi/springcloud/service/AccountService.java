package com.xiaozhi.springcloud.service;

import java.math.BigDecimal;

/**
 * @author xiaozhi
 */
public interface AccountService {

    void decrease(Long userId,BigDecimal money);
}
