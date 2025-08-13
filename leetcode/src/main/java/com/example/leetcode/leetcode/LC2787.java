package com.example.leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2787.将一个数字表示成幂的和的方案数
 *
 * @author panbo
 * @create_time 2025/8/13 15:08
 * @package com.example.leetcode.leetcode
 * @URL <a href="https://leetcode.cn/problems/ways-to-express-an-integer-as-sum-of-powers/description/?envType=daily-question&envId=2025-08-12">...</a>
 **/
public class LC2787 {

    public static void main(String[] args) {
        int n = 100;
        int x = 2;
        System.out.println("方案数为：" + numberOfWays(n, x));
    }

    public static int numberOfWays(int n, int x) {
        // 被取模的MOD
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
