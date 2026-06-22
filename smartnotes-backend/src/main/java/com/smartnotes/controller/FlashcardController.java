package com.smartnotes.controller;

import com.smartnotes.dto.GenerateFlashcardsRequest;
import com.smartnotes.service.FlashcardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flashcards")
@RequiredArgsConstructor
// Replace your existing @CrossOrigin line with this:
@CrossOrigin(origins = {"http://localhost:5173", "https://smartnotes-tau-seven.vercel.app"})
public class FlashcardController {

    private final FlashcardService flashcardService;

    @PostMapping("/generate")
public Object generate(@RequestBody GenerateFlashcardsRequest request) {

    System.out.println("🚨 CONTROLLER HIT");

    try {
        Object result = flashcardService.generateAndSave(
                request.getNotes(),
                request.getSubject()
        );

        System.out.println("✅ SUCCESS");
        return result;

    } catch (Exception e) {
        System.out.println("❌ CONTROLLER ERROR:");
        e.printStackTrace();

        return e.getMessage();
    }
}

    @GetMapping
    public Object getAll() {
        return flashcardService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        flashcardService.delete(id);
    }
}