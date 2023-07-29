package com.example.design.patterns.ChainOfResponsibilityPattern;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * RequestHandlerController
 *
 * @author Panbo
 * @create_time 2023/7/29 23:17
 */
@RestController
@RequestMapping("/ChainOfResponsibilityPatternRequest")
public class RequestHandlerController {

    @Resource
    private RequestProcessor requestProcessor;

    @PostMapping("/handleRequest")
    public void handleRequest() {
        Request request = new Request();
        request.setRequestType(3);
        requestProcessor.processRequest(request);
    }
}
