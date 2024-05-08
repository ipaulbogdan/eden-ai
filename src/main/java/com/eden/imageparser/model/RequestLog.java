package com.eden.imageparser.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;
    private String body;

    @Column(name = "created_datetime")
    private LocalDateTime createdDateTime;

    @PrePersist
    private void initDateTime() {
        if (createdDateTime == null) {
            createdDateTime = LocalDateTime.now();
        }
    }
}
