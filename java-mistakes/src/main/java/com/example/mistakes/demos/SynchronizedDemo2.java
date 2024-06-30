package com.example.mistakes.demos;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
class SynchronizedDemo2 {
    @Getter
    private static int counter = 0;

    public static void reset() {
        counter = 0;
    }

    public static void main(String[] args) {
        SynchronizedDemo2.reset();
        log.info("start -- counter=[{}]", SynchronizedDemo2.getCounter());
        // 多线程循环一定次数调用Data类不同实例的wrong方法
        IntStream.rangeClosed(1, 1000000).parallel().forEach(i -> new SynchronizedDemo2().wrong());
//        // 多线程循环一定次数调用System.out.println
//        IntStream.rangeClosed(1, 1000).parallel().forEach(
//                i -> System.out.println("Thread " + Thread.currentThread().getName() + " running " + i)
//        );
        log.info("end   -- counter=[{}]", SynchronizedDemo2.getCounter());
    }

    public void wrong() {
        synchronized (SynchronizedDemo2.class) {
            counter++;
            // 错误：调用了System.out.println，导致线程不安全
        }
    }
}