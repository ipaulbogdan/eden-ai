package com.eden.imageparser.storage;

import com.eden.imageparser.aws.AwsS3Config;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
@AllArgsConstructor
public class AwsS3StorageProvider implements StorageProvider {

    private S3Client s3Client;
    private AwsS3Config awsS3Config;

    @Override
    public UUID uploadFile(MultipartFile multipartFile){
        var key = UUID.randomUUID();
        var uploadPartRequest = PutObjectRequest.builder()
                        .bucket(awsS3Config.getBucket())
                        .key(key.toString())
                        .build();
        try {
            s3Client.putObject(uploadPartRequest, RequestBody.fromInputStream(multipartFile.getInputStream(), multipartFile.getSize()));
            return key;
        } catch (IOException e) {
            log.error("Unable to upload file {}", multipartFile.getName());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exists(String key) {
        try {
            s3Client.headObject(b -> b.bucket(awsS3Config.getBucket()).key(key));
            return true;
        } catch (NoSuchKeyException e) {
            log.error("Unable to document with key {}", key, e);
            return false;
        }
    }

    @Override
    public byte[] downloadFile(String key) {
        return s3Client.getObjectAsBytes(g -> g.key(key).bucket(awsS3Config.getBucket())).asByteArray();
    }
}
