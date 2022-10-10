package com.example.algorithms.array;

import org.junit.jupiter.api.Test;

class LinkedListTest {


    @Test
    void add() {
        AbstractList<String> list = new LinkedList<>();
        // 添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.printList();
    }

    @Test
    void addFirst() {
        AbstractList<String> list = new LinkedList<>();
        // 添加元素
        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");
        list.addFirst("d");
        list.addFirst("e");
        list.addFirst("f");
        list.addFirst("g");
        list.printList();
    }

    @Test
    void addLast() {
        AbstractList<String> list = new LinkedList<>();
        // 添加元素
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        list.addLast("e");
        list.addLast("f");
        list.addLast("g");
        list.printList();
    }

    @Test
    void pop() {
        AbstractList<String> list = new LinkedList<>();
        // 添加元素
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        list.addLast("e");
        list.addLast("f");
        list.addLast("g");
        list.printList();

        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
        list.printList();
    }

    @Test
    void get() {
        AbstractList<String> list = new LinkedList<>();
        // 添加元素
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        list.addLast("e");
        list.addLast("f");
        list.addLast("g");
        list.printList();

        for (int i = 0; i < 7; i++) {
            System.out.println(list.get(i));
        }
        list.printList();
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void removeByIndex() {
    }

    @Test
    void printList() {
    }
}