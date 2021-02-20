package com.husd.leetcode;

import java.text.DecimalFormat;

/**
 * 这个是字符串操作的一个巧合用法
 *
 * @author hushengdong
 */
public class StringUtils {

    private final static String STR_FORMAT00 = "00";
    private final static String STR_FORMAT000 = "000";

    //格式化补0
    private static String toStringWith00(int num) {
        DecimalFormat df = new DecimalFormat(STR_FORMAT00);
        return df.format(num);
    }

    private static String toStringWith000(int num) {
        DecimalFormat df = new DecimalFormat(STR_FORMAT000);
        return df.format(num);
    }

    // 假设一共有26个小写字母，那么每个小写字母，按顺序，可以组成一个整数，整数是32位，每个数字占据1位
    // 例如abda 可以组成一个整数 1011
    //                       d0ba
    //相当于把字符串去重复之后，表示成为一个数字
    //这个方法，可以用来判断2个字符串是否包含2个相同的字符
    // 判断 abdc 和 aefe 是否包含相同的字符，只需要:
    // s2int(abdc) & s2int(aefe) != 0 如果有相同的字符，结果一定是 != 0
    public static int s2int(String s) {

        int res = 0;
        for (char c : s.toCharArray()) {
            //int a = (int) c - (int) 'a';
            int a = (int) c - 97;
            res |= (1 << a);
        }
        return res;
    }

    public static boolean repeatChar(String s) {

        int res = 0;
        for (char c : s.toCharArray()) {
            //int a = (int) c - (int) 'a';
            int a = (int) c - 97;
            int res1 = (1 << a);
            if (res == res1) return true;
            res = res1;
        }
        return false;
    }

    public static boolean equals(CharSequence cs1, CharSequence cs2) {
        if (cs1 == cs2) {
            return true;
        } else if (cs1 != null && cs2 != null) {
            return cs1 instanceof String && cs2 instanceof String ? cs1.equals(cs2) : CharSequenceUtils.regionMatches(cs1, false, 0, cs2, 0, Math.max(cs1.length(), cs2.length()));
        } else {
            return false;
        }
    }

    public static boolean equalsIgnoreCase(CharSequence str1, CharSequence str2) {
        if (str1 != null && str2 != null) {
            if (str1 == str2) {
                return true;
            } else {
                return str1.length() != str2.length() ? false : CharSequenceUtils.regionMatches(str1, true, 0, str2, 0, str1.length());
            }
        } else {
            return str1 == str2;
        }
    }
}
