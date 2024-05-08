package com.eden.imageparser.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String storageKey;

    @Column(name = "created_datetime")
    private LocalDateTime createdDateTime;

    @PrePersist
    private void initDateTime() {
        if (createdDateTime == null) {
            createdDateTime = LocalDateTime.now();
        }
    }
}
