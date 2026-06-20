package com.smartnotes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateFlashcardsRequest {

    private String notes;

    private String subject;
}
