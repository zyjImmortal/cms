package com.zyj.cms.core.service.geek.leetcode;

/**
 * Author: zhouyajun
 * Date: 2019-07-15
 */
public class NumberSolution {

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
//            因为rev*10.所以rev > Integer.MAX_VALUE / 10 一定会导致溢出，
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * 判断是否是2的倍数
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static boolean isPowerOfTwoV2(int n) {
        if (n <= 0) {
            return false;
        }
        // n如果是2的指数，除以2最后的整数部分一定是1，
        while (n % 2 == 0) { // 先要判断余数部分是不是等于0，等于的话再继续除以2，如果不等于0，而且n也不等于1那就一定不是
            n = n / 2;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }

    public static int mySqrt(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int left = 1, right = n;
        int ans = 0;
        while (left < right) {
            System.out.println("调式代码区间:left = " + left + ", right = " + right);
            int mid = left + (right - left +1 ) / 2;
            long res = (long) mid * mid;
            if (res < n) {
                System.out.println("进入");
                left = mid + 1;
            } else if (res> n) {
                right = mid - 1;
            } else {
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(NumberSolution.mySqrt(9));
//        System.out.println(5 / 2.0);
    }

}
