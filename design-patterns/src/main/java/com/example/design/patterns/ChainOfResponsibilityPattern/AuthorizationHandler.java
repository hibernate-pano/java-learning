package com.example.design.patterns.ChainOfResponsibilityPattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * AuthorizationHandler
 *
 * @author Panbo
 * @create_time 2023/7/29 23:14
 */
@Component
@Slf4j
public class AuthorizationHandler implements RequestHandler {
    @Override
    public void handleRequest(Request request) {
        log.info("AuthorizationHandler handleRequest");
    }

    @Override
    public boolean canHandleRequest(Request request) {
        return request.getRequestType() == 2;
    }
}
