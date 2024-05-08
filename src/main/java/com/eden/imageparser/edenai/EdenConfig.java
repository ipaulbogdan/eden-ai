package com.eden.imageparser.edenai;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "eden-ai")
public class EdenConfig {

    private String baseUrl;
    private String ocrPath;
    private String secretKey;
}
