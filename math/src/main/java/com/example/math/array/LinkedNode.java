package com.example.math.array;

import lombok.Data;

/**
 * 链表节点
 * @author pano
 * @date 2022/10/8
 **/
@Data
public class LinkedNode<T> {

    /**
     * 前驱结点
     */
    private LinkedNode<T> prev;
    /**
     * 节点值
     */
    private T value;
    /**
     * 后继结点
     */
    private LinkedNode<T> next;

    public LinkedNode(LinkedNode<T> prev, T value, LinkedNode<T> next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}
