package com.example.design.patterns.ChainOfResponsibilityPattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * ValidationHandler
 *
 * @author Panbo
 * @create_time 2023/7/29 23:15
 */
@Component
@Slf4j
public class ValidationHandler implements RequestHandler {
    @Override
    public void handleRequest(Request request) {
        System.out.println("ValidationHandler handleRequest");
    }

    @Override
    public boolean canHandleRequest(Request request) {
        return request.getRequestType() == 3;
    }
}
