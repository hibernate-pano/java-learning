package com.example.spring.demos.demo01.impl;

import org.springframework.stereotype.Service;

/**
 * Demo01ServiceImpl
 *
 * @author Panbo
 * @create_time 2023/7/2 18:09
 */
@Service
public class Demo01ServiceImpl {

    private final String demo01Service;

    public Demo01ServiceImpl(String demo01Service) {
        this.demo01Service = demo01Service;
    }

}
