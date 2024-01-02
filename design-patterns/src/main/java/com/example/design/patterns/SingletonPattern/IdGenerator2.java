package com.example.design.patterns.SingletonPattern;

import java.util.concurrent.atomic.AtomicLong;

/**
 * IdGenerator
 * 主键id生成器，使用懒汉式单例模式
 *
 * @author Panbo
 * @create_time 2023/12/24 19:04
 */
public class IdGenerator2 {

    /**
     * 饿汉式单例模式
     */
    private static IdGenerator2 instance;
    /**
     * 使用 AtomicLong 保证线程安全
     */
    private final AtomicLong id = new AtomicLong(0);


    /**
     * 私有化构造函数 !!! 重要 !!! 避免外部创建实例
     */
    private IdGenerator2() {
    }

    /**
     * 懒汉式单例模式
     */
    public static synchronized IdGenerator2 getInstance() {
        if (instance == null) {
            instance = new IdGenerator2();
        }
        return instance;
    }


    public long getId() {
        return id.incrementAndGet();
    }
}
