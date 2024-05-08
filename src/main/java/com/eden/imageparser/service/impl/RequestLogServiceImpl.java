package com.eden.imageparser.service.impl;

import com.eden.imageparser.model.RequestLog;
import com.eden.imageparser.repository.RequestLogRepository;
import com.eden.imageparser.service.RequestLogService;
import com.eden.imageparser.utils.CurrentRequestHandler;
import com.eden.imageparser.utils.CustomObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RequestLogServiceImpl implements RequestLogService {

    private RequestLogRepository requestLogRepository;
    private CustomObjectMapper customObjectMapper;

    @Override
    public List<RequestLog> retrieveAll() {
        saveCurrentRequest(null);
        return requestLogRepository.findAll();
    }

    @Override
    public void saveCurrentRequest(Object body) {
        var jsonBody = customObjectMapper.writeToString(body);

        var request = RequestLog.builder()
                .path(CurrentRequestHandler.getPath())
                .body(jsonBody.orElse(""))
                .build();

        requestLogRepository.save(request);
    }

}
