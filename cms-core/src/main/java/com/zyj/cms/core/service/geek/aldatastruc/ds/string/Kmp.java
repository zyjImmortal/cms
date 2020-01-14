package com.zyj.cms.core.service.geek.aldatastruc.ds.string;

/**
 * @author: zhouyajun
 * @date: 2020-01-14
 */
public class Kmp {
    public static int[] getNexts(char[] b, int m) {

    }

    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
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
