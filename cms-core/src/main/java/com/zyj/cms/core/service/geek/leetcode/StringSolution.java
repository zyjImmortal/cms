package com.zyj.cms.core.service.geek.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author zhouyajun
 * @date 2019/4/18
 */
public class StringSolution {

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int end = s.length - 1;
        int mid = s.length / 2;
        int start = 0;
        while (start <= mid && end >= mid) {
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
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String temp = s.toLowerCase();
        int head = 0, tail = s.length() - 1;
        while (head < tail) {
            char headChar = temp.charAt(head);
            char tailChar = temp.charAt(tail);
            if (!Character.isLetterOrDigit(headChar)) {
                head++;
            } else if (!Character.isLetterOrDigit(tailChar)) {
                tail--;
            } else if (temp.charAt(head) == temp.charAt(tail)) {
                head++;
                tail--;
            }else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeV2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        return false;
    }

    public boolean isValid(String s) {
        HashMap<Character,Character> table = new HashMap<Character, Character>();
        table.put(')','(');
        table.put(']','[');
        table.put('}','{');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == stack.peek()){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }

        }
        return !stack.isEmpty();
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        return null;
    }

    public static void main(String[] args) {
//        char[] s = {'h', 'e', 'l', 'l', 'o'};
        StringSolution stringSolution = new StringSolution();
//        stringSolution.reverseString(s);
//        for (int i = 0; i < s.length; i++) {
//            System.out.println(s[i]);
//        }
        String s = "{[]}";
        System.out.println(stringSolution.isValid(s));
    }
}
