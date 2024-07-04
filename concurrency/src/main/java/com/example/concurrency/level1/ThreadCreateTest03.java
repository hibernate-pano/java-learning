package com.example.concurrency.level1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现 3 个线程依次打印 0-100 的数字
 *
 * @author panbo
 */
public class ThreadCreateTest03 {

    /**
     * 设置最大值
     */
    private static final int MAX_NUM = 100;
    /**
     * 设置最小值
     */
    private static final int MIN_NUM = 1;
    /**
     * 设置可重入锁
     */
    private static final ReentrantLock lock = new ReentrantLock();
    /**
     * 设置 Condition
     */
    private static final Condition condition1 = lock.newCondition();
    private static final Condition condition2 = lock.newCondition();
    private static final Condition condition3 = lock.newCondition();

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(MIN_NUM);

        Thread thread1 = new Thread(() -> {
            while (i.get() < MAX_NUM) {
                lock.lock();
                try {
                    while (i.get() % 3 != 1) {
                        condition1.await();
                    }
                    System.out.println(i.get());
                    if (i.get() == MAX_NUM) {
                        break;
                    }
                    i.getAndIncrement();
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (i.get() < MAX_NUM) {
                lock.lock();
                try {
                    while (i.get() % 3 != 2) {
                        condition2.await();
                    }
                    System.out.println(i.get());
                    if (i.get() == MAX_NUM) {
                        break;
                    }
                    i.getAndIncrement();
                    condition3.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            while (i.get() < MAX_NUM) {
                lock.lock();
                try {
                    while (i.get() % 3 != 0) {
                        condition3.await();
                    }
                    System.out.println(i.get());
                    if (i.get() == MAX_NUM) {
                        break;
                    }
                    i.getAndIncrement();
                    condition1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
