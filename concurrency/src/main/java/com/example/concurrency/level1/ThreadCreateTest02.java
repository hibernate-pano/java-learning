package com.example.concurrency.level1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程创建-测试
 * 用两种不同的方式，创建出两个线程，交叉打印1~100之间的奇数和偶数，并断点调试。
 *
 * @author panbo
 */
public class ThreadCreateTest02 {

    /**
     * 用ReentrantLock和Condition实现两个线程交叉打印奇数和偶数
     * 两个线程分别等待奇数和偶数的打印机，打印机打印完后通知另一个线程继续打印
     * 两个线程都打印完后，打印机打印完毕，两个线程退出
     * 两个线程都用volatile修饰counter，保证打印的数字是正确的
     */
    private final Lock lock = new ReentrantLock();
    private final Condition oddCondition = lock.newCondition();
    private final Condition evenCondition = lock.newCondition();
    private final int limit;
    private volatile int counter = 1;

    public ThreadCreateTest02(int limit) {
        this.limit = limit;
    }

    public static void main(String[] args) {
        ThreadCreateTest02 printer = new ThreadCreateTest02(100);

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();
    }

    public void printOdd() {
        while (counter <= limit) {
            lock.lock();
            try {
                while (counter % 2 == 0) {
                    try {
                        oddCondition.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (counter <= limit) {
                    System.out.println("Odd: " + counter++);
                }
                evenCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printEven() {
        while (counter <= limit) {
            lock.lock();
            try {
                while (counter % 2 != 0) {
                    try {
                        evenCondition.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (counter <= limit) {
                    System.out.println("Even: " + counter++);
                }
                oddCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
