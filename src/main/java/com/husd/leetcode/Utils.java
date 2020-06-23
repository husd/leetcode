package com.husd.leetcode;

/**
 * 这里是这个类的功能描述
 *
 * @author hushengdong
 * @date 2020/3/27
 */
public class Utils {

    /**
     * 判断一个整数在乘以10之后，是否会溢出的方法
     *
     * @param num
     * @return
     */
    public static boolean tooBig(int num) {

        return (num * 10) / 10 != num;
    }

    // 辗转相除法 求最大公约数
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    //求1个数的二进制表示法中，1的个数 结果称为 pop count，或 汉明权重
    //例如： 10010 返回2
    //例如： 10011 返回3
    // n & (n-1) 用来把一个二进制数的最右边1个1，设置为0
    public static int popCount(int n) {

        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }

    //这个是jdk自带的算法 计算一个整数中 2进制表示法的1的个数
    public static int popCountVersion2(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
}
