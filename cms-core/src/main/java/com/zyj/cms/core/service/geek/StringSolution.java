package com.zyj.cms.core.service.geek;

/**
 * @author zhouyajun
 * @date 2019/4/18
 */
public class StringSolution {

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符
     * @param s
     */
    public void reverseString(char[] s) {
        int end = s.length - 1;
        int mid = s.length / 2;
        int start = 0;
         while (start <= mid && end >= mid){
             char temp = s[start];
             s[start] = s[end];
             s[end] = temp;
             start++;
             end--;
         }
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {

        return false;
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        StringSolution stringSolution = new StringSolution();
        stringSolution.reverseString(s);
        for (int i = 0; i < s.length ; i++) {
            System.out.println(s[i]);
        }
    }
}
