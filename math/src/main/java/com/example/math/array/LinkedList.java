package com.example.math.array;

import lombok.Data;

/**
 * @author pano
 * @date 2022/10/8
 **/
@Data
public class LinkedList<T> implements AbstractList<T> {

    /**
     * 新增节点
     *
     * @param t t
     * @return 操作结果
     */
    @Override
    public boolean add(T t) {
        return false;
    }

    /**
     * 从链表开始新增节点
     *
     * @param t t
     * @return 操作结果
     */
    @Override
    public boolean addFirst(T t) {
        return false;
    }

    /**
     * 从链表末尾新增节点
     *
     * @param t t
     * @return 操作结果
     */
    @Override
    public boolean addLast(T t) {
        return false;
    }

    /**
     * 从尾部pop出一个元素
     *
     * @return 操作结果
     */
    @Override
    public T pop() {
        return null;
    }

    /**
     * 获取下标=i的元素
     *
     * @param i 下标
     * @return 下标=i的元素
     */
    @Override
    public T get(int i) {
        return null;
    }

    /**
     * 删除一个元素
     *
     * @param t t
     * @return 操作结果
     */
    @Override
    public boolean remove(T t) {
        return false;
    }

    /**
     * 按照下标删除一个元素
     *
     * @param i 下标
     * @return 操作结果
     */
    @Override
    public boolean removeByIndex(int i) {
        return false;
    }

    /**
     * 打印列表数据
     */
    @Override
    public void printList() {

    }
}
