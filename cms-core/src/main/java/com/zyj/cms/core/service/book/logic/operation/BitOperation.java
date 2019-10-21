package com.zyj.cms.core.service.book.logic.operation;

public class BitOperation {

    public static void main(String[] args) {
        int num = 10;
        System.out.println(num << 4); // 左移运算，相当于乘以2
        System.out.println(num >> 1); // 右移运算，相当于除以2
        int a = 3;
        System.out.println(4&1);

        int x = 4, y=5;

        y = x ^ (y ^ y);
        System.out.println(1^2^3^4^5^1^2^3^4);

        x ^= y;
        y ^= x;
        x ^= y;
        System.out.println(x);
        System.out.println(y);
    }
}
