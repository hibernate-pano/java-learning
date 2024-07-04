package com.example.concurrency.level1;

/**
 * 线程创建-测试
 * 用两种不同的方式，创建出两个线程，交叉打印1~100之间的奇数和偶数，并断点调试。
 *
 * @author panbo
 */
public class ThreadCreateTest01 {

    private final Object lock = new Object();
    private final int limit;
    private volatile int counter = 1;

    public ThreadCreateTest01(int limit) {
        this.limit = limit;
    }

    public static void main(String[] args) {
        ThreadCreateTest01 printer = new ThreadCreateTest01(100);

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();
    }

    /**
     * 打印奇数
     */
    public void printOdd() {
        // 这里的while循环，可以用do-while循环来代替
        while (counter <= limit) {
            synchronized (lock) {
                // 如果是偶数，则等待
                while (counter % 2 == 0) {
                    try {
                        // 等待其他线程通知
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                // 如果counter小于等于limit，则打印
                if (counter <= limit) {
                    System.out.println("Odd: " + counter++);
                }
                // 通知其他线程
                lock.notify();
            }
        }
    }

    public void printEven() {
        while (counter <= limit) {
            synchronized (lock) {
                // 如果是奇数，则等待
                while (counter % 2 != 0) {
                    try {
                        // 等待其他线程通知
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                // 如果counter小于等于limit，则打印
                if (counter <= limit) {
                    System.out.println("Even: " + counter++);
                }
                // 通知其他线程
                lock.notify();
            }
        }
    }
}
