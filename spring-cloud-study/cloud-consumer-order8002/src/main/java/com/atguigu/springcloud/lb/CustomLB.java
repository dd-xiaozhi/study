package com.atguigu.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaozhi
 */
@Component
@Slf4j
public class CustomLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final  int getAndIncrement() {
        int current;
        int next;
        do {
            // 获取当前值
            current = this.atomicInteger.get();
            // 下一次请求数，超过int最大值就设置为0,
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        log.info("*****next*****: {}", next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
