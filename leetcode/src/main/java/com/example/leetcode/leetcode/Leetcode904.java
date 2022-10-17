package com.example.leetcode.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pano
 * @date 2022/10/17
 * @url <a href="https://leetcode.cn/problems/fruit-into-baskets/">fruit-into-baskets</a>
 **/
public class Leetcode904 {

    public static void main(String[] args) {
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit1(fruits));
        // better one
        System.out.println(totalFruit2(fruits));
    }

    /**
     * 最简单的，穷举法
     */
    public static int totalFruit1(int[] fruits) {
        int max = 0;
        for (int i = 0; i < fruits.length; i++) {
            // 当前最大值
            int n = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < fruits.length; j++) {
                if (list.contains(fruits[j])) {
                    n++;
                } else if (list.size() < 2) {
                    list.add(fruits[j]);
                    n++;
                } else {
                    break;
                }
            }
            if (max < n) {
                max = n;
            }
        }
        return max;
    }

    /**
     * 滑动窗口
     */
    public static int totalFruit2(int[] fruits) {
        int max = 0;
        int left = 0, right = 0;
        // key=种类 value=个数
        Map<Integer, Integer> map = new HashMap<>(3);
        // 初始化左节点
        map.put(fruits[left], 0);
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                // 剔除最左边的果树类型和数据
                if (map.getOrDefault(fruits[left], 0) > 1) {
                    map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);
                } else {
                    map.remove(fruits[left]);
                }
                left++;
            }
            // 比较最大值和
            int n = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                n += entry.getValue();
            }
            if (max < n) {
                max = n;
            }
            // 向右滑动
            right++;
        }
        return max;
    }
}
