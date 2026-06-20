package com.smartnotes.service;

import org.springframework.stereotype.Service;

@Service
public class GeminiService {

    public String generateFlashcards(String notes) {

        System.out.println("⚡ MOCK GEMINI USED");

        return """
        [
          {
            "question": "What is Java?",
            "answer": "Java is a programming language"
          },
          {
            "question": "What is OOP?",
            "answer": "Object Oriented Programming"
          },
          {
            "question": "What is a class?",
            "answer": "A blueprint for objects"
          }
        ]
        """;
    }
}