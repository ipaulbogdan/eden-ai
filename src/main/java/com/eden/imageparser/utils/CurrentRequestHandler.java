package com.eden.imageparser.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CurrentRequestHandler {

    public static String getPath() {
        var request = getCurrentRequest();

        return request.getRequestURI();
    }

    private static HttpServletRequest getCurrentRequest() {
        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        Assert.state(attrs instanceof ServletRequestAttributes, "No current ServletRequestAttributes");
        return ((ServletRequestAttributes)attrs).getRequest();
    }
}
