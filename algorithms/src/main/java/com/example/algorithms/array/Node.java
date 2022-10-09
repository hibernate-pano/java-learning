package com.example.algorithms.array;

import lombok.Data;

/**
 * 链表节点
 *
 * @author pano
 * @date 2022/10/8
 **/
@Data
public class Node<T> {

    /**
     * 前驱结点
     */
    private Node<T> prev;
    /**
     * 节点值
     */
    private T value;
    /**
     * 后继结点
     */
    private Node<T> next;

    /**
     * 全参数构造函数
     *
     * @param prev  前驱节点
     * @param value 值
     * @param next  后驱节点
     */
    public Node(Node<T> prev, T value, Node<T> next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}
