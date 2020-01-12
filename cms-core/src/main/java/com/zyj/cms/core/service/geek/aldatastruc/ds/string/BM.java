package com.zyj.cms.core.service.geek.aldatastruc.ds.string;

import javax.lang.model.type.ErrorType;

public class BM {
    private static final int SIZE = 256;

    private void generateBC(char[] patStr, int patLength, int[] bc) {
        // 初始化散列表
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }
        // 根据ascii值记录字符的位置
        for (int i = 0; i < patLength; i++) {
            int ascii = patStr[i];
            bc[ascii] = i;
        }
    }

    public int bm(char[] mainStr, int mainLength, char[] patStr, int patLength) {
        int[] bc = new int[SIZE];
        // 这里数组作为散列表，索引就是ascii值，存的是字符在模式字符串中的位置，根据字符计算出ascii值就可以快速获取位置
        generateBC(patStr, patLength, bc);
        int i = 0;
        while (i <= mainLength - patLength) {
            int j;
            // 遍历模式字符串，如果发现不匹配的字符，那就停止查找，这个时候j就是坏字符在模式串中的位置
            for (j = patLength - 1; j > 0; j--) {
                if (mainStr[i + j] != patStr[j]) {
                    break;
                }
            }
            // 如果j小于，就是说在模式字符串中没有坏字符，完全匹配，就找到了，直接返回i
            // 也就是模式字符串开头字符在主串中的位置
            if (j < 0) {
                return i;
            }
            // mainStr[i + j] 取出的就是坏字符，bc[mainStr[i + j]]在散列表中查找坏字符，如果有就返回就返回在模式串中的位置
            // j -  bc[mainStr[i + j]] 就是滑动的位数
            i = i + (j - bc[mainStr[i + j]]);
        }
        return -1;
    }

    /**
     *
     * @param patStr 模式字符串
     * @param patLength 模式字符串长度
     * @param suffix  散列表 下表作为公共后缀字串的长度，存储的是公共后缀子串的起始下标
     * @param prefix 记录模式串的后缀子串是否能匹配模式串的前缀子串，索引也是公共后缀字串的长度
     */
    private void generateGS(char[] patStr, int patLength, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < patLength; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }

        // i 控制截取字串的长度
        for (int i = 0; i < patLength - 1; i++) {
            int j = i;
            int k = 0; // 表示公共后缀字串长度
            // 字串和模式字符串都是从后往前开始遍历，寻找公共后缀字串
            while (j >= 0 && patStr[j] == patStr[patLength - 1 - k]) {
                k++; // 公共后缀字串的长度
                suffix[k] = j;
                j--;
            }
            // 表示某个字串既是前缀字串又是后缀子串
            if (j == -1) {
                prefix[k] = true;
            }
        }
    }



}
