package com.example.design.patterns.ChainOfResponsibilityPattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * AuthenticationHandler
 *
 * @author Panbo
 * @create_time 2023/7/29 23:13
 */
@Slf4j
@Component
public class AuthenticationHandler implements RequestHandler {
    @Override
    public void handleRequest(Request request) {
        log.info("AuthenticationHandler handleRequest");
    }

    @Override
    public boolean canHandleRequest(Request request) {
        return request.getRequestType() == 1;
    }
}
