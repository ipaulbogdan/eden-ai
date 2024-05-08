package com.eden.imageparser.aws;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
@AllArgsConstructor
public class AwsConfiguration {

    private AwsS3Config awsS3Config;
    private AwsS3Credentials awsS3Credentials;

    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .region(Region.of(awsS3Config.getRegion()))
                .endpointOverride(awsS3Config.getEndpoint())
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(awsS3Credentials.getAccessKey(), awsS3Credentials.getSecretKey())))
                .forcePathStyle(true)
                .build();
    }
}
