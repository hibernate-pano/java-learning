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
    public Node<T> get(int i) {
        // 判断长度
        if (i >= size) {
            return null;
        }
        Node<T> node = first;
        for (int j = 0; j < i; j++) {
            node = node.getNext();
        }
        return node;
    }

    /**
     * 删除一个元素
     *
     * @param node node
     * @return 操作结果
     */
    @Override
    public T remove(Node<T> node) {
        if (node == null){
            return null;
        }
        final T element = node.getValue();
        final Node<T> prev = node.getPrev();
        final Node<T> next = node.getNext();
        // 去头
        if (prev == null){
            first = next;
        } else {
            prev.setNext(next);
            node.setPrev(null);
        }
        // 去尾
        if (next == null){
            last = prev;
        } else {
            next.setPrev(prev);
            node.setNext(null);
        }
        node.setValue(null);
        size--;
        return element;
    }

    /**
     * 根据值删除一个元素
     *
     * @param t t
     * @return 操作结果
     */
    @Override
    public boolean remove(T t) {
        // 遍历整个链表，获取value=t的元素，并删除
        for (int i = 0; i < size; i++) {
            Node<T> node = get(i);
            if (node.getValue().equals(t)){
                remove(node);
            }
        }
        return true;
    }

    /**
     * 按照下标删除一个元素
     *
     * @param i 下标
     * @return 操作结果
     */
    @Override
    public T removeByIndex(int i) {
        Node<T> node = get(i);
        return remove(node);
    }

    /**
     * 打印列表数据
     */
    @Override
    public void printList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(get(i).getValue().toString());
        }
        System.out.println(sb);
    }
}
