package com.aoaojiao.ai;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.template.st.StTemplateRenderer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.util.Map;

@SpringBootTest
class AoaojiaoAiApplicationTests {

    @DisplayName("测试模板字段串")
    @Test
    void testPropmtTemplate() {
        String name = "林俊杰";
        PromptTemplate promptTemplate = PromptTemplate.builder()
                .renderer(StTemplateRenderer.builder().startDelimiterToken('<').endDelimiterToken('>').build())
                .template("""
                        告诉我这个人是谁：<who>
                        """)
                .build();
        String prompt = promptTemplate.render(Map.of("who", name));
        System.out.println(prompt);
    }

    @Value("classpath:/st/test-prompt.st")
    public Resource promptTemplateSt;

    @DisplayName("测试 st 模板")
    @Test
    void testStPropmtTp() {
        PromptTemplate pt = PromptTemplate.builder().resource(promptTemplateSt).build();
        String prompt = pt.render(Map.of("who", "林俊杰"));
        System.out.println(prompt);
    }


}
