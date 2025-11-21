package com.example.leetcode.leetcode;

/**
 * 326. 3 的幂
 *
 * @author panbo
 * @create_time 2025/8/13 15:13
 * @package com.example.leetcode.leetcode
 * @URL <a href="https://leetcode.cn/problems/power-of-three/description/?envType=daily-question&envId=2025-08-12">...</a>
 **/
public class LC326 {

    /**
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x
     * <p>
     * !!!!精度问题？？？？？！
     */
    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int max = 0;

        // 获取整数范围内 3 的最大的幂次方
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (Math.pow(3, i) > Integer.MAX_VALUE) {
                max = (int) Math.pow(3, i - 1);
                break;
            }
        }
        return n % 3 == 0 && max % n == 0;
    }

    public static void main(String[] args) {
        System.out.print(isPowerOfThree(243));
    }
}
