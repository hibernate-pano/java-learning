package com.example.algorithms.dynamic_programming;

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
        int n = 3;
        int W = 5;
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};

        int result = method1(n, W, v, w);
        System.out.println(result);
    }
}
