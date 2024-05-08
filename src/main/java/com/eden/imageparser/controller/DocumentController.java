package com.eden.imageparser.controller;

import com.eden.imageparser.dto.DocumentOcrRequestDto;
import com.eden.imageparser.dto.DocumentOcrResponseDto;
import com.eden.imageparser.model.Document;
import com.eden.imageparser.service.DocumentService;
import com.eden.imageparser.service.RequestLogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/documents")
@AllArgsConstructor
public class DocumentController {

    private DocumentService documentService;
    private RequestLogService requestLogService;

    @PostMapping
    public Document uploadDocument(@RequestParam MultipartFile file) {
        requestLogService.saveCurrentRequest("");
        return documentService.saveDocument(file);
    }

    @PostMapping("/actions/ocr-launch")
    public DocumentOcrResponseDto launchOcr(@RequestBody DocumentOcrRequestDto documentOcrRequestDto) {
        requestLogService.saveCurrentRequest(documentOcrRequestDto);
        return documentService.analyseDocument(documentOcrRequestDto);
    }

}
