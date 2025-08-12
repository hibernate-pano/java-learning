package com.example.algorithms.dynamic_programming;

/**
 * 动态规划之爬楼梯
 *
 * @author panbo
 * @create_time 2025/8/12 14:36
 * @package com.example.algorithms.dynamic_programming
 **/
public class ClimbingStairsDemo {

    public static int climb_1(int n) {
        // 初始化
        // 反直觉设计，为了更好的运算。
        if (n < 2) {
            return 1;
        }
        // 定义
        int[] dp = new int[n + 1];
        // 反直觉设计，为了更好的运算。正常来说 “dp[0] = 0” 才对
        dp[0] = 1;
        dp[1] = 1;
        // 状态转移方程
        // 到达 i 阶台阶的方法，可以是 i-1阶台阶+1，也可以是 i-2阶台阶+2
        // 所以这里是到达 i-1 阶的所有方法数 + 到达 i-2阶的所有方法数
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            System.out.println("dp[" + i + "] = " + dp[i]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int result = climb_1(n);
        System.out.println("1爬到第" + n + "阶台阶的方法有" + result + "种");
    }
}
