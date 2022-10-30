package com.example.lamda.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author pano
 * @date 2022/10/26
 **/
public class LambdaDemo {

    public static <T> void foreach(List<T> list, Consumer<T> consumer) {
        for (T s : list) {
            consumer.accept(s);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> list2 = new ArrayList<>();
        for (T t : list) {
            R r = function.apply(t);
            list2.add(r);
        }
        return list2;
    }

    public static void main(String[] args) {
        LambdaDemo.foreach(List.of(1, 2, 3, 4, 5), System.out::println);
        List<Integer> map = LambdaDemo.map(List.of("aa", "bbb", "ccc"), String::length);
        System.out.println(map);
    }
}
