package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vocabularies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vietnamese; // Từ tiếng Việt chuyên ngành IT

    @Column(nullable = false)
    private String khmer;      // Từ tiếng Khmer tương ứng

    private String phonetic;   // Cách phát âm cho Tú dễ học

    @Column(columnDefinition = "TEXT")
    private String example;    // Ví dụ minh họa

    private LocalDateTime createdAt = LocalDateTime.now();
}