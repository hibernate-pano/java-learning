package com.example.algorithms.sorting;

/**
 * 插入排序
 * 1. 时间复杂度 O(n^2)
 * 2. 空间复杂度 O(1)
 * 3. 稳定性：稳定
 *
 * @author panbo
 * @create_time 2025/11/21 10:28
 **/
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // 当前要插入的元素
            int j = i - 1; // 已排序部分的最后一个索引

            // 将大于key的元素向后移动
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // 插入key到正确位置
            arr[j + 1] = key;
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        System.out.println("排序前的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // 调用插入排序方法
        insertionSort(arr);

        System.out.println();
        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}



