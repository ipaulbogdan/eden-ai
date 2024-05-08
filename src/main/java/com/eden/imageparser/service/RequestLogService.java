package com.eden.imageparser.service;

import com.eden.imageparser.model.RequestLog;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface RequestLogService {

    List<RequestLog> retrieveAll();

    void saveCurrentRequest(Object body);
}
