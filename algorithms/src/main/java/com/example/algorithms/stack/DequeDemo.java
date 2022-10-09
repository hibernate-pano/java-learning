package com.example.algorithms.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 一个可用的栈结构
 *
 * @author pano
 * @date 2022/9/26
 **/
public class DequeDemo {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        Integer pop1 = deque.pop();
        Integer pop2 = deque.pop();
        System.out.println(pop1);
        System.out.println(pop2);
    }
}
