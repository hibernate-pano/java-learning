package com.example.stream.stream;

import java.util.List;

/**
 * @author pano
 * @date 2022/10/31
 **/
public class FlatMapDemo2 {

    public static void main(String[] args) {

        List<Integer> num1 = List.of(1, 2, 3, 4, 5);
        List<Integer> num2 = List.of(6, 7, 8);

        List<int[]> collect = num1.stream()
                .flatMap(i -> num2.stream().map(j -> new int[]{i, j}))
                .toList();
        collect.stream().map(String::valueOf).forEach(System.out::println);
    }
}
