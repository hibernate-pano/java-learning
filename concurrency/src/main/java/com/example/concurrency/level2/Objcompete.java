package com.example.concurrency.level2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author panbo
 */
public class Objcompete {

    private static final AtomicInteger num = new AtomicInteger(0);

    private Objcompete() {
    }

    public static Objcompete getObjcompeteInstance() {
        return ObjcompeteInstance.SINGLE_TON_04;
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Objcompete.class);
        Objcompete objcompete = Objcompete.getObjcompeteInstance();
        Set<Integer> numSet = ConcurrentHashMap.newKeySet();
        // 使用 CompletableFuture.supplyAsync 替代 CompletableFuture.runAsync
        CompletableFuture[] completableFutures = new CompletableFuture[1000];
        for (int i = 0; i < 1000; i++) {
            completableFutures[i] = CompletableFuture.supplyAsync(() -> {
                synchronized (objcompete) {
                    objcompete.doSomething();
                    return objcompete.getNum();
                }
            }).thenAccept(num -> {
                if (!numSet.add(num)) {
                    System.out.println("Duplicate num: " + num);
                }
            });
        }

        // 等待所有的任务完成
        CompletableFuture.allOf(completableFutures).join();

        logger.info("多线程执行完成后，最终的结果是: {}", numSet.size());
    }


    public Integer getNum() {
        return num.get();
    }

    public void doSomething() {
        num.incrementAndGet();
    }

    private static class ObjcompeteInstance {
        private static final Objcompete SINGLE_TON_04 = new Objcompete();
    }
}