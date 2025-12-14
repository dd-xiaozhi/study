package com.xiaozhi.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiaozhi
 */
@Mapper
public interface StorageMapper {

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
