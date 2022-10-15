package com.example.leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pano
 * @date 2022/10/15
 * @url <a href="https://leetcode.cn/problems/build-an-array-with-stack-operations/">build-an-array-with-stack-operations</a>
 **/
public class Leetcode1441 {

    public static void main(String[] args) {
        int[] target = {1, 3};
        int n = 3;
        System.out.println(Leetcode1441.buildArray(target, n));
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> steps = new ArrayList<>();
        String push = "Push";
        String pop = "Pop";
        int length = target.length;
        for (int i = 1; i < n + 1; i++) {
            if (target[length - 1] < i) {
                return steps;
            }
            steps.add(push);
            boolean flag = false;
            for (int k : target) {
                if (k == i) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                steps.add(pop);
            }
        }
        return steps;
    }
}
