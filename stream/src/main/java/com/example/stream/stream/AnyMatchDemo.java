package com.example.stream.stream;

import java.util.List;

/**
 * @author pano
 * @date 2022/10/31
 **/
public class AnyMatchDemo {

    public static void main(String[] args) {
        List<Integer> num = List.of(1, 2, 3, 4, 5);
        boolean b = num.stream().anyMatch(n -> n == 1);
        System.out.println(b);

        System.out.println(num.stream().mapToInt(Integer::valueOf).sum());
        num.stream().reduce(Integer::sum).ifPresent(System.out::println);
    }
}
