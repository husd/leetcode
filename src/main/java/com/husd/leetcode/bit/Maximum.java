package com.husd.leetcode.bit;

/**
 * 面试题 16.07. 最大数值
 * <p>
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * <p>
 * 示例：
 * <p>
 * 输入： a = 1, b = 2
 * 输出： 2
 *
 * @author hushengdong
 */
public class Maximum {

    //这种题目，毫无意义
    //max(a, b) = ((a + b) + abs(a - b)) / 2
    public int maximum(int a, int b) {

        long aL = (long) a;
        long bL = (long) b;
        long sum = aL + bL;
        long diff = aL - bL;
        long absDiff = (diff ^ (diff >> 63)) - (diff >> 63);
        long c = (sum + absDiff) / 2;
        return (int) c;
    }
}
