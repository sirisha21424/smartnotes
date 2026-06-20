package com.smartnotes.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flashcards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    @Column(length = 2000)
    private String question;

    @Column(length = 5000)
    private String answer;
}
