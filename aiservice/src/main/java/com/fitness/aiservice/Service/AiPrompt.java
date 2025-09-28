package com.fitness.aiservice.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service

public class AiPrompt {

    private final WebClient webClient;

    @Value("${gimini.api.url}")
    private String getGeminiUrl;
    @Value("${gimini.api.key}")
    private String getGeminiKey;

    public AiPrompt(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }

    public String getAnswer(String question)
    {
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]
                                {
                                        Map.of("text",question)
                                })
                }
        );
        return webClient.post().
                uri(getGeminiUrl+"?key="+getGeminiKey).
                header("Content-Type","application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }
}
