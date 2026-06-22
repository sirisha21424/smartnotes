package com.smartnotes.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class GeminiService {

    public String generateFlashcards(String notes) {

        String prompt = """
You are an expert flashcard generator.

Generate AT LEAST 6 flashcards.
Generate up to 10 flashcards if the topic contains enough information.

Rules:
1. Never generate fewer than 6 flashcards.
2. Cover the most important concepts of the topic.
3. Each flashcard must contain a concise question and answer.
4. Return ONLY a valid JSON array.
5. Do not include explanations, markdown, or extra text.

Format:
[
  {
    "question": "...",
    "answer": "..."
  }
]

Input:
""" + notes;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = Map.of(
                "model", "qwen2.5:3b",
                "prompt", prompt,
                "stream", false
        );

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(body, headers);

        try {

            Map response = restTemplate.postForObject(
                    "http://localhost:11434/api/generate",
                    entity,
                    Map.class
            );

            return response.get("response").toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "[]";
        }
        
    }
}