package com.example.design.patterns.SingletonDesignPattern;

import java.util.concurrent.atomic.AtomicLong;

/**
 * IdGenerator
 * 主键id生成器，是用静态内部类的写法
 *
 * @author Panbo
 * @create_time 2023/12/24 19:04
 */
public class IdGenerator3 {

    /**
     * 使用 AtomicLong 保证线程安全
     */
    private final AtomicLong id = new AtomicLong(0);

    /**
     * 私有化构造函数 !!! 重要 !!! 避免外部创建实例
     */
    private IdGenerator3() {
    }

    public static IdGenerator3 getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    private static class SingletonHolder {
        private static final IdGenerator3 instance = new IdGenerator3();
    }
}
