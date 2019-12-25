package com.zyj.cms.core.service.geek.AlAndDataStruc.ds.string;

/**
 * @author zhouyajun
 * @date 2019/4/10
 */
public class StringExecise {

    private static String reverseStr(String str) {
        StringBuilder builder = new StringBuilder();
        char[] chars = new char[str.length()];
        str.getChars(0, str.length(), chars, 0);
        for (int i = 0; i < str.length(); i++) {
            builder.append(chars[i]);
        }
        return builder.reverse().toString();
    }

    public static boolean isRecycleString(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        int mod = length % 2;
        int mid = length / 2;
        if (mod == 0) {
            return str.substring(0, mid).equals(StringExecise.reverseStr(str.substring(mid, length)));
        } else {
            return str.substring(0, mid).equals(StringExecise.reverseStr(str.substring(mid + 1, length)));
        }
    }

    /**
     * 利用两个栈来处理回文字符串
     * 一个栈从前往后存数据，另一个栈从后往前存数据，然后同时出站进行比对，如果出现不相等的就
     * 判定不是回文字符串
     *
     * @param str
     */

    public static boolean isRecycleStringStack(String str) {
        return true;
    }

    public static void main(String[] args) {
        String str = "1234321";
        System.out.println(StringExecise.isRecycleString(str));
    }
}
