package com.eden.imageparser.dto;

import com.eden.imageparser.edenai.dto.EdenQuery;

import java.util.List;

public record DocumentOcrRequestDto(List<String> providers,
                                   List<EdenQuery> queries,
                                   Long documentId) {
}
