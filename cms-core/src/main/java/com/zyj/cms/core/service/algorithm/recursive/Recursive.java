package com.zyj.cms.core.service.algorithm.recursive;

import java.util.HashMap;

/**
 * 什么样的问题可以用递归来解决，递归满足的条件
 * 1、一个问题的解可以分为几个子问题的解
 * 2、这个问题与分解后的子问题，除了数据规模不同，求解思路完全一样
 * 3、存在递归终止条件，不能存在无限循环
 * <p>
 * 关键点：
 * 写出递归公式，就是找到如何将大问题分解为小问题的规律
 * 找到终止条件
 * <p>
 * 递归要注意的问题
 * 1、栈溢出：函数调用会使用栈来保存临时变量。每调用一个函数，都会将临时变封装为栈帧压入栈，可以设置设置最大递归深度解决
 * 2、重复计算：设置散列表来存储计算过的值
 * 3、思考递归问题的时候，要尽量屏蔽掉递归的细节，只思考问题与子问题的关系即可
 */
public class Recursive {

    /**
     * 每次只能走一阶台阶或者两阶台阶，总共n阶台阶有多少总走法
     *
     * @param n
     * @return
     */
    public static int recursive(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    public static int recursiveV2(int n) {
        HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (results.get(n) != null) {
            return results.get(n);
        }
        int ret = recursiveV2(n - 1) + recursiveV2(n - 2);
        results.put(n, ret);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Recursive.recursive(15));
        System.out.println(Recursive.recursiveV2(15));
    }
}
