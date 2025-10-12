package com.aoaojiao.ai.controller;

import com.aoaojiao.ai.tools.DateTimeTool;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.nio.charset.StandardCharsets;

/**
 * @author DD
 */
@RestController
@AllArgsConstructor
@RequestMapping("/ai/tool")
public class ToolController {

    private final ChatClient chatClient;

    @RequestMapping("/send")
    public Flux<String> toolChat(@RequestBody String prompt, HttpServletResponse response) {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        return chatClient.prompt()
                .system("你是一个助手，回答我提问的问题：")
                .user(prompt)
                .tools(new DateTimeTool())
                .stream()
                .content();
    }
}
