package com.eden.imageparser.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class CustomObjectMapper {

    private ObjectMapper objectMapper;

    public Optional<String> writeToString(Object object) {
        try {
            return Optional.of(objectMapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            log.error("Failed to serialise object", e);
            return Optional.empty();
        }
    }


}
