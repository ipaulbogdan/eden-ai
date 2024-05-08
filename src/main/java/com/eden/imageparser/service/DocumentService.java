package com.eden.imageparser.service;

import com.eden.imageparser.dto.DocumentOcrRequestDto;
import com.eden.imageparser.dto.DocumentOcrResponseDto;
import com.eden.imageparser.model.Document;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

    Document saveDocument(MultipartFile file);

    DocumentOcrResponseDto analyseDocument(DocumentOcrRequestDto documentOcrRequestDto);

}
