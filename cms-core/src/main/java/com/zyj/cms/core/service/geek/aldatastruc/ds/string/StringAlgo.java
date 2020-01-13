package com.zyj.cms.core.service.geek.aldatastruc.ds.string;

/**
 * @author: zhouyajun
 * @date: 2020-01-10
 */
public class StringAlgo {
    public static int bF(String mainStr, String matStr) {
        int n = mainStr.length(), m = matStr.length(), k;
        if (m > n) {
            return -1;
        }
        char[] mainChars = mainStr.toCharArray();
        char[] matChars = matStr.toCharArray();
        // 外层循环控制向右滑动次数，i记录滑动位置
        for (int i = 0; i <= n - m; i++) {
            // k记录在一次比较过程中相等字符的个数
            k = 0;
            for (int j = 0; j < m; j++) {
                if (mainChars[i + j] == matChars[j]) {
                    k++;
                } else {
                    // 在一次比较过程中，如果有不相等的字符，就结束后次轮的比较，滑动进行下一轮的比较
                    break;
                }
            }
            // 判断再一次比较完结束后，相等字符的个数是否和模式串的个数相等，如果相等就说明匹配到了，
            // 如果不相等，就向右滑动，进行下一轮比较
            if (k == m) {
                return i;
            }
        }
        return -1;
    }


    public static int rK(String mainStr, String matStr) {
        int m = mainStr.length(), n = matStr.length(), s, j;
        int[] hash = new int[m - n + 1];
        int[] table = new int[26];
        char[] a1 = mainStr.toCharArray();
        char[] b1 = matStr.toCharArray();
        s = 1;
        //将26的次方存储在一个表里，取的时候直接用,虽然溢出，但没啥问题
        for (j = 0; j < 26; j++) {
            table[j] = s;
            s *= 26;
        }
        for (int i = 0; i <= m - n; i++) {
            s = 0;
            for (j = 0; j < n; j++) {
                s += (a1[i + j] - 'a') * table[n - 1 - j];
            }
            hash[i] = s;
        }
        s = 0;
        for (j = 0; j < n; j++) {
            s += (b1[j] - 'a') * table[n - 1 - j];
        }
        for (j = 0; j < m - n + 1; j++) {
            if (hash[j] == s) {
                return j;
            }
        }
        return -1;
    }
}
