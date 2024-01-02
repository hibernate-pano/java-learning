package com.example.design.patterns.SingletonPattern;

import java.util.concurrent.atomic.AtomicLong;

/**
 * IdGenerator
 * 主键id生成器，使用枚举完成
 *
 * @author Panbo
 * @create_time 2023/12/24 19:04
 */
public enum IdGenerator4 {

    INSTANCE;

    private final AtomicLong id = new AtomicLong(0);

    public static void main(String[] args) {
        System.out.println(IdGenerator4.INSTANCE.getId());
        System.out.println(IdGenerator4.INSTANCE.getId());
        System.out.println(IdGenerator4.INSTANCE.getId());
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
