package com.husd.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的所有组合，比如 abc：
 * a
 * b
 * c
 * ab
 * ac
 * bc
 * abc
 *
 * @author hushengdong
 */
public class AllSubString {

    public static void main(String[] args) {

        String str = "abc";
        int len = str.length();
        List<String> target = p(str, 0, len);
        System.out.println(target);
    }

    private static List<String> p(String str, int i, int len) {

        if (i == len) {
            return null;
        }
        if (i == len - 1) {
            List<String> t = new ArrayList<>(1);
            t.add(String.valueOf(str.charAt(i)));
            return t;
        }
        List<String> tmp = p(str, i + 1, len);
        List<String> tmp2 = new ArrayList<>();
        if (tmp != null) {
            for (String s : tmp) {
                tmp2.add(s);
                tmp2.add(s + str.charAt(i));
            }
        }
        tmp2.add(String.valueOf(str.charAt(i)));
        return tmp2;
    }


}
