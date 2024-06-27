package com.example.concurrency.level1;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义 UncaughtExceptionHandler
 *
 * @author pano
 * @date 2022/11/21
 **/
@Slf4j
public class ExceptionDemo {

    public static void main(String[] args) {
        Thread demoThread = new Thread(() -> {
            throw new RuntimeException("aaaaa");
        });
        demoThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler());
        demoThread.start();
    }

    /**
     * 内部类
     */
    static class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        /**
         * Method invoked when the given thread terminates due to the
         * given uncaught exception.
         * <p>Any exception thrown by this method will be ignored by the
         * Java Virtual Machine.
         *
         * @param t the thread
         * @param e the exception
         */
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            log.error("出错了！线程名：" + t.getName() + "，错误信息：" + e.getMessage());
        }
    }

}
