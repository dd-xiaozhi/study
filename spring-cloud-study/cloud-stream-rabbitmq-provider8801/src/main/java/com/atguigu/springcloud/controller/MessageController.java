package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.intf.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaozhi
 */
@RestController
public class MessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String send() {
        return iMessageProvider.send();
    }
}
