package com.husd.leetcode.math;

/**
 * 29. 两数相除
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 * <p>
 * 提示：
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class Divide {

    //TODO 值得一看
    //这道题，全部转负数，就能解决溢出的问题 至于为什么能解决溢出，需要再思考
    //
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; //处理越界
        if (dividend == 0) return 0;
        //符号位
        boolean sign = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) ? true : false;
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;
        return sign ? -neg_div(dividend, divisor) : neg_div(dividend, divisor);
    }

    //负数除法
    private int neg_div(int dividend, int divisor) {
        int base = 0;
        //这2个while需要好好思考下
        while (dividend <= divisor) {
            long x = divisor, times = 1;
            while (x > (dividend >> 1)) {
                x <<= 1;
                times <<= 1;
            }
            base += times;
            dividend -= x;
        }
        return base;
    }


    //自己的解法，没通过
    public int divide2(int dividend, int divisor) {

        if (dividend == 0) return 0;
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int sum = 0;
        int res = 0;
        while (sum < dividend) {
            sum += divisor;
            res++;
        }
        if (sign == 1) {
            return sum == dividend ? res : res - 1;
        }
        return sum == dividend ? -res : 1 - res;
    }

    public static void main(String[] args) {

        Divide m = new Divide();
        int a = m.divide(110, 5);
        System.out.println(a);
    }
}
