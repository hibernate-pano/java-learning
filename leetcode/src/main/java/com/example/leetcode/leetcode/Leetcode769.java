package com.example.leetcode.leetcode;

/**
 * @author pano
 * @date 2022/10/13
 * @url <a href="https://leetcode.cn/problems/max-chunks-to-make-sorted/">max-chunks-to-make-sorted</a>
 **/
public class Leetcode769 {

    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 1, 0};
        int[] arr2 = {1, 0, 2, 3, 4};
        int[] arr3 = {4, 0, 1, 3, 2};
        int[] arr4 = {2, 1, 0, 3, 4};
        int[] arr6 = {0, 1, 2, 3, 4};
        int[] arr7 = {0, 1};
        int[] arr8 = {0};
        System.out.println(Leetcode769.maxChunksToSorted(arr1));
        System.out.println(Leetcode769.maxChunksToSorted(arr2));
        System.out.println(Leetcode769.maxChunksToSorted(arr3));
        System.out.println(Leetcode769.maxChunksToSorted(arr4));
        System.out.println(Leetcode769.maxChunksToSorted(arr6));
        System.out.println(Leetcode769.maxChunksToSorted(arr7));
        System.out.println(Leetcode769.maxChunksToSorted(arr8));
    }

    public static int maxChunksToSorted(int[] arr) {
        // 从首位开始，到下一个在自己位置上的数组，中间的数字区间包含这些index，则可以算作一个独立的块
        // 最起码有一个block
        int blockNumber = 0;
        int maxValue = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxIndex < i) {
                maxIndex = i;
            }
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
            if (maxValue == maxIndex) {
                blockNumber++;
            }
        }
        return blockNumber;
    }
}
