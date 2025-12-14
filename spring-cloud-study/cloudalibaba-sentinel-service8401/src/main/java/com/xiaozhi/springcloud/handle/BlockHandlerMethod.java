package com.xiaozhi.springcloud.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author xiaozhi
 */
public class BlockHandlerMethod {

    public static String returnMethod01(BlockException exception) {
        return "BlockHandlerMethod1 Method";
    }

    public static String returnMethod02(BlockException exception) {
        return "BlockHandlerMethod2 Method";
    }
}
