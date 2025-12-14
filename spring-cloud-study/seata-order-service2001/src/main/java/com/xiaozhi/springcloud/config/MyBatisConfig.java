package com.xiaozhi.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.xiaozhi.springcloud.mapper"})
public class MyBatisConfig {
}