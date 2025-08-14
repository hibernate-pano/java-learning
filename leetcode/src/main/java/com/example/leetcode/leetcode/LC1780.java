package com.example.leetcode.leetcode;

/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 *
 * @author panbo
 * @create_time 2025/8/14 09:20
 * @package com.example.leetcode.leetcode
 * @URL <a href="https://leetcode.cn/problems/check-if-number-is-a-sum-of-powers-of-three/description/?envType=daily-question&envId=2025-08-14">...</a>
 **/
public class LC1780 {

    public static boolean checkPowersOfThree(int n) {
        // 思考转成三进制问题
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(1));
        System.out.println(checkPowersOfThree(4));
        System.out.println(checkPowersOfThree(5));
        System.out.println(checkPowersOfThree(6));
        System.out.println(checkPowersOfThree(91));
    }
}
