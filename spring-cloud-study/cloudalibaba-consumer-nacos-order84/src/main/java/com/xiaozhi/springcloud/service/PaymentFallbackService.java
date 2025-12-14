package com.xiaozhi.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.utils.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author xiaozhi
 */
@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(444, "请求人数过多，请销后重试~~~");
    }
}
