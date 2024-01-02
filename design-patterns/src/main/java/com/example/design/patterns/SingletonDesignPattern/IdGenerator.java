package com.example.design.patterns.SingletonDesignPattern;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * IdGenerator
 * 主键id生成器，使用饿汉式单例模式
 *
 * @author Panbo
 * @create_time 2023/12/24 19:04
 */
public class IdGenerator {
    /**
     * 饿汉式单例模式
     */
    @Getter
    private static final IdGenerator instance = new IdGenerator();

    /**
     * 使用 AtomicLong 保证线程安全
     */
    private final AtomicLong id = new AtomicLong(0);

    /**
     * 私有化构造函数 !!! 重要 !!! 避免外部创建实例
     */
    private IdGenerator() {
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
