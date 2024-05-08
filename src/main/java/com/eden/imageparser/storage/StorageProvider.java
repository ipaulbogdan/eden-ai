package com.eden.imageparser.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

public interface StorageProvider {

    UUID uploadFile(MultipartFile multipartFile);

    boolean exists(String key);

    byte[] downloadFile(String key);

}