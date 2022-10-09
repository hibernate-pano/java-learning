package com.example.algorithms.array;

/**
 * 抽象list接口，具有所有list的集合属性
 *
 * @author pano
 * @date 2022/10/8
 **/
public interface AbstractList<T> {

    /**
     * 新增节点
     *
     * @param t t
     * @return 操作结果
     */
    boolean add(T t);

    /**
     * 从链表开始新增节点
     *
     * @param t t
     * @return 操作结果
     */
    boolean addFirst(T t);

    /**
     * 从链表末尾新增节点
     *
     * @param t t
     * @return 操作结果
     */
    boolean addLast(T t);

    /**
     * 从尾部pop出一个元素
     *
     * @return 操作结果
     */
    T pop();

    /**
     * 获取下标=i的 Node
     *
     * @param i 下标
     * @return 下标=i的元素
     */
    Node<T> get(int i);

    /**
     * 删除一个元素
     *
     * @param node node
     * @return 操作结果
     */
    T remove(Node<T> node);

    /**
     * 根据值删除一个元素
     * @param t t
     * @return 操作结果
     */
    boolean remove(T t);

    /**
     * 按照下标删除一个元素
     *
     * @param i 下标
     * @return 操作结果
     */
    T removeByIndex(int i);

    /**
     * 打印列表数据
     */
    void printList();
}
