package com.husd.leetcode.math;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * <p>
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class PrintNumbers {

    //这种题垃圾
    public int[] printNumbers(int n) {

        int[] empty = {};
        if (n <= 0) return empty;
        int c = 1;
        int n1 = n;
        while (n1 > 0) {
            n1--;
            c = c * 10;
        }
        int len = c - 1;
        int len1 = (int) Math.pow(10, n);
        int[] a = new int[c - 1];
        for (int i = 1; i < c; i++) {
            a[i - 1] = i;
        }
        return a;
    }

    public static void main(String[] args) {

        PrintNumbers m = new PrintNumbers();
        int[] a = m.printNumbers(2);
        System.out.println(2);
    }
}
