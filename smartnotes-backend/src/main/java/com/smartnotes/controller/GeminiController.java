package com.smartnotes.controller;

import com.smartnotes.dto.FlashcardResponse;
import com.smartnotes.service.FlashcardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") 
public class GeminiController {

    private final FlashcardService flashcardService;

    public GeminiController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @PostMapping("/flashcards")
    public ResponseEntity<List<FlashcardResponse>> generate(@RequestBody String notes) {
        System.out.println("🚀 Controller received request for notes: " + notes);
        
        List<FlashcardResponse> responseList = flashcardService.generateAndSave(notes, "General");
        return ResponseEntity.ok(responseList);
    }
}