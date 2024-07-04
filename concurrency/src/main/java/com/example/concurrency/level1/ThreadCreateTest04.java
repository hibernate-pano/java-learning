package com.example.concurrency.level1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现 3 个线程依次打印 0-100 的数字
 *
 * @author panbo
 */
public class ThreadCreateTest04 {

    /**
     * 设置最大值
     */
    private static final int MAX_NUM = 100;
    /**
     * 设置最小值
     */
    private static final int MIN_NUM = 1;
    /**
     * 设置信号量
     */
    private static final Semaphore semaphore1 = new Semaphore(3);
    private static final Semaphore semaphore2 = new Semaphore(4);
    private static final Semaphore semaphore3 = new Semaphore(5);

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(MIN_NUM);

        Thread thread1 = new Thread(() -> printNumber(i, semaphore1, semaphore2, 1));
        thread1.setName("Thread1");
        Thread thread2 = new Thread(() -> printNumber(i, semaphore2, semaphore3, 2));
        thread2.setName("Thread2");
        Thread thread3 = new Thread(() -> printNumber(i, semaphore3, semaphore1, 0));
        thread3.setName("Thread3");

        thread3.start();
        thread2.start();
        thread1.start();
    }

    private static void printNumber(AtomicInteger i, Semaphore current, Semaphore next, int remainder) {
        while (i.get() <= MAX_NUM) {
            try {
                current.acquire();
                if (i.get() > MAX_NUM) {
                    next.release();
                    break;
                }
                if (i.get() % 3 == remainder) {
                    System.out.println(Thread.currentThread().getName() + " --- " + i.get());
                    i.getAndIncrement();
                } else {
                    System.out.println(Thread.currentThread().getName() + " --- " + i.get() + " not print");
                }
                next.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}