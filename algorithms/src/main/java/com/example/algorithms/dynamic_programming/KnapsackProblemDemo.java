package com.example.algorithms.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * 01-背包问题
 * <p>
 * 你有一个容量为 W 的背包，和 n 个物品。 每个物品有两个属性：价值 v 和重量 w。
 * 你需要选择一些物品放入背包中，使得放入背包的物品的总重量不超过 W，同时使得放入背包的物品的总价值最大。
 * 每个物品要么完整放入，要么不放入，不能只放入一部分，这就是 “0-1” 的含义。
 *
 * @author panbo
 * @create_time 2025/8/12 16:36
 * @package com.example.algorithms.dynamic_programming
 **/
public class KnapsackProblemDemo {

    /**
     * 01背包问题思路
     * 使用动态规划解决01背包问题，计算在给定背包容量和物品信息下能获得的最大价值
     *
     * @param n 物品数量
     * @param W 背包总重量
     * @param w 物品重量数组
     * @param v 物品价值数组
     * @return 在背包容量限制下能获得的最大价值
     */
    public static int method1(int n, int W, int[] v, int[] w) {

        // 状态定义
        int[][] dp = new int[n + 1][W + 1];

        // 如果没有物品、没有背包，则最大价值为 0
        // 初始化
        if (n == 0 || W == 0) {
            return 0;
        }

        // 状态转移方程
        // 外层循环遍历物品，内层循环遍历背包容量
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                // 判断 w[i-1] 是否超过 W，如果超过就证明放不下第 i 个物品，则当前的最大值=前一个最大值
                if (w[i - 1] > j) {
                    // 装不下当前物品，最大价值与前i-1个物品相同
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装得下当前物品，比较装与不装的价值，取较大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }

        // 返回
        return dp[n][W];
    }

    public static void main(String[] args) {
//        int n = 3;
//        int W = 5;
//        int[] w = {1, 2, 3};
//        int[] v = {6, 10, 12};
//
//        int result = method1(n, W, v, w);
//        System.out.println(result);


        int result2 = numberOfWays(226, 1);
        System.out.println(result2);
    }

    /**
     * 给你两个 正整数 n 和 x 。
     * 请你返回将 n 表示成一些"互不相同"正整数的 x 次幂之和的方案数。换句话说，你需要返回互不相同整数 [n^1, n^2, ..., n^k] 的集合数目，满足 n = n1^x + n2^x + ... + nk^x 。
     * 由于答案可能非常大，请你将它对 10^9 + 7 取余后返回。
     * 比方说，n = 160 且 x = 3 ，一个表示 n 的方法是 n = 2^3 + 3^3 + 5^3 。
     *
     * @param n 正整数 n ，是最后的总和
     * @param x 幂次 x
     * @return 方案数
     */
    public static int numberOfWays(int n, int x) {
        final int MOD = 1_000_000_007;
        // 状态定义
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 1;
        // 获取所有的备选的幂值(物品的价值)
        List<Integer> powers = new ArrayList<>();
        for (int i = 1; ; i++) {
            long pow = (long) Math.pow(i, x);
            if (pow > n) {
                break;
            }
            powers.add((int) pow);
        }
        // 状态转移方程
        for (int pow : powers) {
            // pow 一定是小于 n 的，因为上面已经过滤掉了所有大于 n 的pow
            // 倒序执行，避免数据的重复，严格遵守0-1原则
            for (int i = n; i > pow - 1; i--) {
                // 第 i 个数组成的方案数 = 不选择第 i 个数 + 选择了第 i 个数
                dp[i] = (dp[i] + dp[i - pow]) % MOD;
            }
        }
        return dp[n];
    }
}
