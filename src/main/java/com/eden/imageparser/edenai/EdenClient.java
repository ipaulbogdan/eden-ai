package com.eden.imageparser.edenai;

import com.eden.imageparser.edenai.dto.EdenOcrLaunchResponse;
import com.eden.imageparser.edenai.dto.EdenQuery;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@AllArgsConstructor
public class EdenClient {

    private EdenConfig edenConfig;
    private RestTemplate edenRestTemplate;
    private ResourceLoader resourceLoader;

    @SneakyThrows
    public EdenOcrLaunchResponse launchOcr(List<String> providers, List<EdenQuery> queries, byte[] file) {
        var requestBuilder = new MultipartBodyBuilder();
        requestBuilder.part("providers", providers);
        requestBuilder.part("queries", queries);
        requestBuilder.part("file", file);

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        var multipartBody = requestBuilder.build();
        var httpEntity = new HttpEntity<>(multipartBody, headers);

        return edenRestTemplate.postForEntity(edenConfig.getOcrPath(), httpEntity, EdenOcrLaunchResponse.class)
                .getBody();
    }
}
