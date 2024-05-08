package com.eden.imageparser.aws;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Getter
@Setter
@ConfigurationProperties(prefix = "aws.s3")
@Configuration
public class AwsS3Config {

    private URI endpoint;
    private String region;
    private String bucket;
}
