package com.huey.learning.spring.ai.ollama;

import jakarta.annotation.Resource;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ollama
 *
 * @author huey
 */
@RestController
@RequestMapping("/ollama")
public class OllamaController {

    @Resource
    private OllamaChatModel ollamaChatModel;

    @RequestMapping("/chat")
    public Object chat(String message) {
        return ollamaChatModel.call(message);
    }

}
