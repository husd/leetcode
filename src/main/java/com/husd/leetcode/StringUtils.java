package com.husd.leetcode;

/**
 * 这个是字符串操作的一个巧合用法
 *
 * @author hushengdong
 */
public class StringUtils {

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
}
