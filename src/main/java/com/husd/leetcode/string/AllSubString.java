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

        //String str = "abcdefghijklmnopqrstuvwxyz";
        String str = "abcdefghijklmnopqrstuvwx";
        int len = str.length();
//        long t1 = System.currentTimeMillis();
//        List<String> target = p(str, 0, len);
//        long t2 = System.currentTimeMillis();
//        //Collections.sort(target);
//        //System.out.println(target);
//        System.out.println(t2 - t1);

        long t3 = System.currentTimeMillis();
        List<String> target2 = p2(str, len);
        long t4 = System.currentTimeMillis();
        //Collections.sort(target2);
        //System.out.println(target2);
        System.out.println(t4 - t3);
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

    //这个版本，在字符串长度很低的时候，性能很好。
    // 在abcdefghijklmnopqrstuvwx 这个长度的时候，就很慢了。
    private static List<String> p2(String str, int len) {

        List<String> target = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            int len1 = target.size();
            for (int j = 0; j < len1; j++) {
                target.add(target.get(j) + c);
            }
            target.add(String.valueOf(c));
        }
        return target;
    }


}
