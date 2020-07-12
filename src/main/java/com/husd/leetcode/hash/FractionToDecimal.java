package com.husd.leetcode.hash;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 示例 1:
 *
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 *
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 *
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FractionToDecimal {

    //TODO 值得一看
    //TODO 还没做出来 没处理是否循环
    public String fractionToDecimal(int numerator, int denominator) {

        if(numerator % denominator == 0) {
            return String.valueOf(numerator / denominator);
        }
        int a = numerator / denominator;
        int b = numerator * 10 / denominator;
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(".(");
        sb.append(b);
        sb.append(")");
        return sb.toString();
    }
}
