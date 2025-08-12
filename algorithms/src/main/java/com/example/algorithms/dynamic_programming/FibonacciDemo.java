package com.example.algorithms.dynamic_programming;

/**
 * 斐波那契数列
 *
 * @author panbo
 * @create_time 2025/8/12 10:59
 * @package com.example.algorithms.dynamic_programming
 **/
public class FibonacciDemo {

    /**
     * 使用动态规划计算斐波那契数列的第 n 项
     *
     * @param n 要计算的斐波那契数列的项数 (n >= 0)
     * @return 第 n 个斐波那契数的值
     */
    public static int fibonacci(int n) {
        // 1. 定义状态：dp[i] 表示第 i 个斐波那契数的值
        // 新建一个长度为 n+1 的数组，用来保存从 0 到 n 的所有斐波那契数；
        int[] dp = new int[n + 1];
        // 2. 初始化基本情况
        dp[0] = 0;
        if (n > 0) {
            dp[1] = 1;
        }
        // 3. 建立状态转移方程并确定计算顺序
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 返回结果
        return dp[n];
    }


    public static int fibonacci_with_memo(int n, int[] memo) {
        // 使用 memo 记忆功能（实际上就是缓存）来做斐波那契数
        // 一般使用数组或者哈希表来做 memo
        // 判断长度，如果溢出，返回 -1
        if (memo.length < n + 1) {
            return -1;
        }
        // 0 = 0 ,1 =1
        if (n < 2) {
            return n;
        }
        // 如果有数据，则获取
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = fibonacci_with_memo(n - 1, memo) + fibonacci_with_memo(n - 2, memo);

        return memo[n];
    }

    /**
     * 这个优化版本的空间复杂度仅为O(1)，是计算斐波那契数列的最优解法。
     */
    public static int fibonacci_optimized(int n) {
        if (n < 2) {
            return n;
        }

        int prev2 = 0; // F(0)
        int prev1 = 1; // F(1)
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }


    public static void main(String[] args) {
        // 示例
        int n = 10;
        int result = fibonacci(n);
        System.out.println("斐波那契数列1的第 " + n + " 项是: " + result); // 输出: 斐波那契数列的第 10 项是: 55

        int[] memo = new int[n + 1];
        int result2 = fibonacci_with_memo(n, memo);
        System.out.println("斐波那契数列2的第 " + n + " 项是: " + result2); //

        int result3 = fibonacci_optimized(n);
        System.out.println("斐波那契数列3的第 " + n + " 项是: " + result3); //
    }
}
