package com.xiaozhi.springcloud.mapper;

import com.xiaozhi.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiaozhi
 */
@Mapper
public interface OrderMapper {

    void create(Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
