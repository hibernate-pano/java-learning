package com.example.stream.future;

import org.springframework.util.StopWatch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 测试 CompletableFuture 的使用
 * 测试结果实际 5008193775 ns = 5008 ms 约等于一个线程执行的任务事件
 * 测试效果非常让人满意
 *
 * @author pano
 * @date 2022/11/2
 **/
public class CompletableFutureDemo {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CompletableFuture<Double> future1 = CompletableFuture.supplyAsync(CompletableFutureDemo::query1);
        CompletableFuture<Double> future2 = CompletableFuture.supplyAsync(CompletableFutureDemo::query2);
        CompletableFuture<Double> future3 = CompletableFuture.supplyAsync(CompletableFutureDemo::query3);
        CompletableFuture<Double> future4 = CompletableFuture.supplyAsync(CompletableFutureDemo::query4);
        Double query5 = CompletableFutureDemo.query5();
        double sum;
        try {
            sum = query5 + future4.get() + future3.get() + future2.get() + future1.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        stopWatch.stop();
        System.out.println(sum);
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * 四个方法，每个延迟5秒
     */
    private static Double query1() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Math.random();
    }

    private static Double query2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Math.random();
    }

    private static Double query3() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Math.random();
    }

    private static Double query4() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Math.random();
    }

    private static Double query5() {
        return Math.random();
    }
}
