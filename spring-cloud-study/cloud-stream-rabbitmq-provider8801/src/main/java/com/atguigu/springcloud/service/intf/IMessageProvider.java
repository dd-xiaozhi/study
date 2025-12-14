package com.atguigu.springcloud.service.intf;

/**
 * @author xiaozhi
 */
public interface IMessageProvider {

    /**
     * 生成消息
     * @return
     */
    String send();
}
