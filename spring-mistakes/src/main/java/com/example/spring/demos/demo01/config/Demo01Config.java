package com.example.spring.demos.demo01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Demo01Config
 *
 * @author Panbo
 * @create_time 2023/7/2 18:22
 */
@Component
public class Demo01Config {

    @Bean
    public String demo01Service() {
        return "demo01Service";
    }
}
