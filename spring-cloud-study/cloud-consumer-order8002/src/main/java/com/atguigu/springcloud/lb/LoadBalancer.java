package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author xiaozhi
 */
public interface LoadBalancer {

    /**
     * 获取服务实例
     * @param serviceInstances 服务实例列表
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
