package com.smartnotes.dto;

import lombok.Data;

@Data
public class GenerateFlashcardsRequest {

    private String notes;
    private String subject;

}
