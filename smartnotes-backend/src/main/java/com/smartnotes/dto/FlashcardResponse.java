package com.smartnotes.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlashcardResponse {

    private Long id;

    private String subject;

    private String question;

    private String answer;
}