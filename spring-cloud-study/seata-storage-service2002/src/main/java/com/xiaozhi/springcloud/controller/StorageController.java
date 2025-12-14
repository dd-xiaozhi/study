package com.xiaozhi.springcloud.controller;

import com.xiaozhi.springcloud.domain.CommonResult;
import com.xiaozhi.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaozhi
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult createOrder(@RequestParam("productId") Long productId,
                                    @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣除仓库库存成功~~~");
    }
}
