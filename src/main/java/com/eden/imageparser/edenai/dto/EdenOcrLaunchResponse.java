package com.eden.imageparser.edenai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EdenOcrLaunchResponse(@JsonProperty("public_id") String publicId) {
}
