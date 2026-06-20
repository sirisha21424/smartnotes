package com.smartnotes.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartnotes.dto.FlashcardResponse;
import com.smartnotes.entity.Flashcard;
import com.smartnotes.repository.FlashcardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FlashcardService {

    private final FlashcardRepository flashcardRepository;
    private final GeminiService geminiService;

    public List<FlashcardResponse> generateAndSave(String notes, String subject) {

    System.out.println("🚨 SERVICE WORKING");

    String geminiJson = geminiService.generateFlashcards(notes);

    ObjectMapper mapper = new ObjectMapper();

    List<Map<String, String>> cards;

    try {
        cards = mapper.readValue(
                geminiJson,
                new TypeReference<List<Map<String, String>>>() {}
        );
    } catch (Exception e) {
        throw new RuntimeException("JSON parsing failed: " + e.getMessage());
    }

    List<FlashcardResponse> result = new ArrayList<>();

    for (Map<String, String> card : cards) {

        Flashcard flashcard = Flashcard.builder()
                .subject(subject)
                .question(card.get("question"))
                .answer(card.get("answer"))
                .build();

        Flashcard saved = flashcardRepository.save(flashcard);

        result.add(FlashcardResponse.builder()
                .id(saved.getId())
                .subject(saved.getSubject())
                .question(saved.getQuestion())
                .answer(saved.getAnswer())
                .build());
    }

    System.out.println("✅ DONE");

    return result;
}

       

    public List<Flashcard> getAll() {
        return flashcardRepository.findAll();
    }

    public void delete(Long id) {
        flashcardRepository.deleteById(id);
    }
}