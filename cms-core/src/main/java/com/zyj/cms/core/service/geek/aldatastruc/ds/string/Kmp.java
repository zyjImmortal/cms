package com.zyj.cms.core.service.geek.aldatastruc.ds.string;

/**
 * @author: zhouyajun
 * @date: 2020-01-14
 */
public class Kmp {
    /**
     * next的数组推到过程是假设已经有部分数据计算出来，以此为基础计算后面的
     * 这里说的最公共子串，指的是，模式串从开头到当前位置的子串的所有前缀子串和后缀子串的最长公共子串
     * <p>
     * 假设模式串中0-9位对应的公共最长子串已经计算出来，此时要计算第10位字符'a'对应的最大公共子串长度
     * 首先考虑加了一个字符，最大公共子串长度是否会加一，这个时候可以利用已经求出的第9位的最大公共子串，
     * 假设第九位最大公共子串是abaa，此时看这个前缀子串的后面一个字符是否和新字符'a'相等，如果相等，那最长公共子串长度就+1
     * <p>
     * 如果不相等，就只能考虑最长长度不变或者减小的情况了。
     * 此时要找的是，最大前缀的前缀和最大后缀加'a'字符组合的后缀的公共最长的子串了，
     * <p>
     * 最长前缀和最长后缀是一样的，那么问题就转换成，最长前缀加新字符的公共最长的子串了，就又回到了开始时的规则了
     * <p>
     * 整体解决思路类似于一个动态规划的问题，求某个位置的所有前缀子串和所有后缀子串的公共子串长度，
     * 可以通过前一个位置的公最长共子串长度得出。
     *
     * @param b
     * @param m
     * @return
     */
    public static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < m; i++) {
            while (b[i] != b[j + 1] && j >= 0) {
                j = next[j];
            }
            // 如果i位置的字符和最大前缀子串的后面一个字符相等，那么i位置的最大前缀子串长度就+1
            if (b[i] == b[j + 1]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * next 数组存的是当前
     * 从模式串头部到当前位置的这一子串的，
     * 所有前缀子串和所有后缀子串匹配到最长公共子串时
     * 前缀子串的最后一个字符的索引
     *
     * @param a
     * @param n
     * @param b
     * @param m
     * @return
     */
    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        // i 是主串指针，j是模式串指针
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && b[j] != a[i]) {
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                j++;
            }

            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

}
