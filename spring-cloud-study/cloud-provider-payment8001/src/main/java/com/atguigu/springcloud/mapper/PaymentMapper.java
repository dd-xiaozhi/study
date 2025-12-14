package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xiaozhi
 */
@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentById(long id);
}
