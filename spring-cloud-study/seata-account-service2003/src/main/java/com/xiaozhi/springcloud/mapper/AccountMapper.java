package com.xiaozhi.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author xiaozhi
 */
@Mapper
public interface AccountMapper {

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
