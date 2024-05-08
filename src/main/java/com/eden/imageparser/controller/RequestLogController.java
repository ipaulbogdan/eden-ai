package com.eden.imageparser.controller;

import com.eden.imageparser.model.RequestLog;
import com.eden.imageparser.service.RequestLogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@AllArgsConstructor
public class RequestLogController {

    private RequestLogService requestLogService;

    @GetMapping
    public List<RequestLog> getAll() {
        return requestLogService.retrieveAll();
    }

}
