package com.example.stream.stream;

import java.util.Arrays;

/**
 * 去重
 *
 * @author pano
 * @date 2022/10/30
 **/
public class FlatMapDemo {

    public static void main(String[] args) {
        String[] strings = {"hello", "world"};
        Arrays.stream(strings)
                // 转换成单个字符的数组
                .map(s -> s.split(""))
                // 合并流
                .flatMap(Arrays::stream)
                // 去重
                .distinct()
                // 输出
                .forEach(System.out::print);
    }
}
