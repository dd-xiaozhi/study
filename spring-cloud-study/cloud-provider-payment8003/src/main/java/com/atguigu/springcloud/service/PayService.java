package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiaozhi
 */
public interface PayService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
