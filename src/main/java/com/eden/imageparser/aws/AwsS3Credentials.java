package com.eden.imageparser.aws;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(prefix = "aws.s3")
@Configuration
public class AwsS3Credentials {

    private String accessKey;
    private String secretKey;
}
