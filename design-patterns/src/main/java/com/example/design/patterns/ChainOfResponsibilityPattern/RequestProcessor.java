package com.example.design.patterns.ChainOfResponsibilityPattern;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * RequestProcessor
 *
 * @author Panbo
 * @create_time 2023/7/29 23:15
 */
@Component
public class RequestProcessor {

    private final List<RequestHandler> requestHandlers;

    public RequestProcessor(List<RequestHandler> requestHandlers) {
        this.requestHandlers = requestHandlers;
    }

    public void processRequest(Request request) {
        for (RequestHandler requestHandler : requestHandlers) {
            if (requestHandler.canHandleRequest(request)) {
                requestHandler.handleRequest(request);
                break;
            }
        }
    }
}
