package com.example.concurrency.level1;

/**
 * 线程创建
 *
 * @author panbo
 */
public class ThreadCreate {

    public static void main(String[] args) {
        Thread a = new Thread(new ThreadA());
        a.start();
        a.run();

        Thread b = new Thread(new ThreadB());
        b.start();
        b.run();
    }

    /**
     * 第一种方法：继承一个 Thread 类
     */
    static class ThreadA extends Thread {
        @Override
        public void run() {
            System.out.println("创建 threadA 完成" + Thread.currentThread().getName());
        }
    }

    /**
     * 第二种方法：实现 Runnable 接口
     */
    static class ThreadB implements Runnable {
        @Override
        public void run() {
            System.out.println("创建 threadB 完成" + Thread.currentThread().getName());
        }
    }
}
