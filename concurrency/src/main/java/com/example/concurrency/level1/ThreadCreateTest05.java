package com.example.concurrency.level1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现 3 个线程依次打印 0-100 的数字
 *
 * @author panbo
 */
public class ThreadCreateTest05 {

    /**
     * 设置最大值
     */
    private static final int MAX_NUM = 100;
    /**
     * 设置最小值
     */
    private static final int MIN_NUM = 1;

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(MIN_NUM);

        Thread thread1 = new Thread(() -> printNumber(i, 1));
        thread1.setName("Thread1");
        Thread thread2 = new Thread(() -> printNumber(i, 2));
        thread2.setName("Thread2");
        Thread thread3 = new Thread(() -> printNumber(i, 0));
        thread3.setName("Thread3");

        thread3.start();
        thread2.start();
        thread1.start();
    }

    private static void printNumber(AtomicInteger i, int remainder) {
        while (i.get() <= MAX_NUM) {
            if (i.get() > MAX_NUM) {
                break;
            }
            if (i.get() % 3 == remainder) {
                synchronized (ThreadCreateTest05.class) {
                    System.out.println(Thread.currentThread().getName() + " --- " + i.get());
                    i.getAndIncrement();
                }
            } else {
//                System.out.println(Thread.currentThread().getName() + " --- " + i.get() + " not print");
            }
        }
    }
}