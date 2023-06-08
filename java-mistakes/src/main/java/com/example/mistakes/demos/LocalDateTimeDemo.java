package com.example.mistakes.demos;

import cn.hutool.core.date.LocalDateTimeUtil;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author pano
 * @date 2023/5/15
 **/
public class LocalDateTimeDemo {

    public static void main(String[] args) {
        Integer time = Math.toIntExact(LocalDateTimeUtil.between(LocalDateTime.now(), LocalDateTime.now().plusHours(24), ChronoUnit.MINUTES));
        System.out.println(time);
    }
}
