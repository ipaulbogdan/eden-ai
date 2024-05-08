package com.eden.imageparser.edenai;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
@AllArgsConstructor
public class EdenConfiguration {

    @Bean
    public RestTemplate edenRestTemplate(EdenConfig edenConfig) {
        return new RestTemplateBuilder()
                .defaultHeader(AUTHORIZATION, "Bearer " + edenConfig.getSecretKey())
                .rootUri(edenConfig.getBaseUrl())
                .build();
    }

}
