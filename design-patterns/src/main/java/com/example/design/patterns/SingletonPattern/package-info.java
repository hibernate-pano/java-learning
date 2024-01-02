/**
 * 单例模式
 * 1.避免资源浪费；
 * 2.避免资源争夺；
 * 3.表明全局唯一类；
 *
 * @author Panbo
 * @create_time 2023/12/24 18:56
 */
package com.example.design.patterns.SingletonPattern;

// 此处举例是一个 idGenerator 全局唯一的 id 生成器。推荐使用枚举类，这也是java官方推荐的方式，enum 枚举类天生就是单例的，系统只初始化一次。
