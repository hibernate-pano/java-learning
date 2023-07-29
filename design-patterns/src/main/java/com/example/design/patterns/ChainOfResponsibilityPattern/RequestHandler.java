package com.example.design.patterns.ChainOfResponsibilityPattern;

/**
 * RequestHandler
 *
 * @author Panbo
 * @create_time 2023/7/29 23:11
 */
public interface RequestHandler {

    void handleRequest(Request request);

    boolean canHandleRequest(Request request);
}
