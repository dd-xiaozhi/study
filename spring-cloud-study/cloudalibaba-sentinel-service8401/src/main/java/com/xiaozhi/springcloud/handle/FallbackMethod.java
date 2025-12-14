package com.xiaozhi.springcloud.handle;

/**
 * @author xiaozhi
 */
public class FallbackMethod {

    public static String fallbackMethod01(Throwable exception) {
        return "fallbackMethod01 Method";
    }

    public static String fallbackMethod02(Throwable exception) {
        return "fallbackMethod01 Method";
    }
}
