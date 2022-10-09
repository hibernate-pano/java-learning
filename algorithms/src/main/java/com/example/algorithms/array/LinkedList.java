package com.example.algorithms.array;

import lombok.Data;

/**
 * @author pano
 * @date 2022/10/8
 **/
@Data
public class LinkedList<T> implements AbstractList<T> {

    transient int size = 0;

    transient Node<T> first;

    transient Node<T> last;

    /**
     * 空参数构造函数
     */
    public LinkedList() {
    }

    /**
     * 新增节点
     *
     * @param t t
     * @return 操作结果
     */
    @Override
    public boolean add(T t) {
        return addFirst(t);
    }

    /**
     * 从链表开始新增节点
     *
     * @param t t
     * @return 操作结果
     */
    @Override
    public boolean addFirst(T t) {
        final Node<T> font = first;
        final Node<T> newNode = new Node<>(null, t, font);
        first = newNode;
        if (font != null) {
            font.setPrev(newNode);
        } else {
            last = newNode;
        }
        // 修改链表长度
        size++;
        return true;
    }

    /**
     * 从链表末尾新增节点
     *
     * @param t t
     * @return 操作结果
     */
    @Override
    public boolean addLast(T t) {
        final Node<T> back = last;
        final Node<T> newNode = new Node<>(back, t, null);
        last = newNode;
        if (back != null) {
            back.setNext(newNode);
        } else {
            first = newNode;
        }
        // 修改链表长度
        size++;
        return true;
    }

    /**
     * 从尾部pop出一个元素
     *
     * @return 操作结果
     */
    @Override
    public T pop() {
        if (last == null) {
            return null;
        }
        final Node<T> back = last;
        last = back.getPrev();
        last.setNext(null);
        // 修改链表长度
        size--;
        return back.getValue();
    }

    /**
     * 获取下标=i的元素
     *
     * @param i 下标
     * @return 下标=i的元素
     */
    @Override
    public T get(int i) {
        // 判断长度
        if (i >= size) {
            return null;
        }
        Node<T> font = first;
        for (int j = 0; j < i; j++) {
            font = font.getNext();
        }
        return font.getValue();
    }

    /**
     * 删除一个元素
     *
     * @param t t
     * @return 操作结果
     */
    @Override
    public boolean remove(T t) {


        size--;
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
