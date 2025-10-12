package com.aoaojiao.ai.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.LocalDateTime;

/**
 * @author DD
 */
@Slf4j
public class DateTimeTool {

    @Tool(description = "Get the current date and time in the user's timezone")
    String getCurrentDateTime() {
        log.info("执行当前 tool");
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
    }
}
