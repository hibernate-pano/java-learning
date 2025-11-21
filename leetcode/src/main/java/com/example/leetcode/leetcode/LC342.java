package com.example.leetcode.leetcode;

/**
 * 342. 4的幂
 *
 * @author panbo
 * @create_time 2025/8/15 11:35
 * @package com.example.leetcode.leetcode
 * @URL <a href="https://leetcode.cn/problems/power-of-four/description/?envType=daily-question&envId=2025-08-15">...</a>
 **/
public class LC342 {

    public static boolean isPowerOfFour(int n) {
//        // 处理特殊情况
//        if (n <= 0) {
//            return false;
//        }
//        if (n == 1) {
//            return true;
//        }
//        // 求所有符合条件的4的幂
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i < Integer.MAX_VALUE; i++) {
//            double pow = Math.pow(4, i);
//            if (pow < Integer.MAX_VALUE) {
//                list.add((int) pow);
//            }
//        }
//        return list.contains(n);
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(20));
        System.out.println(isPowerOfFour(-1));
        System.out.println(isPowerOfFour(0));
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(8));
        System.out.println(isPowerOfFour(1024));
    }
}
