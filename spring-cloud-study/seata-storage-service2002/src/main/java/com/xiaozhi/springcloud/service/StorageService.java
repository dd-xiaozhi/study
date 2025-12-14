package com.xiaozhi.springcloud.service;

/**
 * @author xiaozhi
 */
public interface StorageService {

    void decrease(Long productId, Integer count);
}
