package com.eden.imageparser.service.impl;

import com.eden.imageparser.dto.DocumentOcrRequestDto;
import com.eden.imageparser.dto.DocumentOcrResponseDto;
import com.eden.imageparser.edenai.EdenClient;
import com.eden.imageparser.model.Document;
import com.eden.imageparser.repository.DocumentRepository;
import com.eden.imageparser.service.DocumentService;
import com.eden.imageparser.storage.StorageProvider;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private DocumentRepository documentRepository;
    private EdenClient edenClient;
    private StorageProvider storageProvider;

    @Override
    public Document saveDocument(MultipartFile file) {
        var documentKey = storageProvider.uploadFile(file);

        var document = Document.builder()
                .storageKey(documentKey.toString())
                .name(file.getOriginalFilename())
                .build();

        return documentRepository.save(document);
    }

    @Override
    public DocumentOcrResponseDto analyseDocument(DocumentOcrRequestDto documentOcrRequestDto) {
        var document = documentRepository.findById(documentOcrRequestDto.documentId())
                .orElseThrow(() -> new EntityNotFoundException("Unable to find document with provided key: " + documentOcrRequestDto.documentId()));

        var fileBytes = storageProvider.downloadFile(document.getStorageKey());
        var edenResponse = edenClient.launchOcr(documentOcrRequestDto.providers(), documentOcrRequestDto.queries(), fileBytes);

        return new DocumentOcrResponseDto(edenResponse.publicId());
    }
}
