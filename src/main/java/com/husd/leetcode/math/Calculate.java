package com.husd.leetcode.math;

import java.util.Stack;

/**
 * 224. 基本计算器
 * <p>
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 * <p>
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class Calculate {

    //TODO 值得一看
    //TODO 重点研究

    //经典的计算机算法，非常值得研究,

    //1 递归写法，强撸 虽然结果可能会正确，但是是野路子，不是
    //学习算法的正道 尝试了下，有点复杂，不弄了 直接上正解

    // 思路就是  134 + 2 - 3  == 1 + 2 + (-3)
    // 如果是数字，就计算这个数字是多少
    // 如果是加号 或者减号 就把res 的值和当前值，做加法
    // 如果是左括号( 就把res的值暂时先放入栈中（记得放入符号)
    // 如果是右括号，就把栈里的数据弹出来，然后和当前值做加法
    public int calculate(String s) {

        s = s.trim();

        int res = 0;
        //声明2个栈，1个是数字，1个是操作符号
        Stack<Integer> num = new Stack<>();
        int end = s.length();
        int operand = 0;
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < end; i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                operand = 10 * operand + (int) (c - '0');
            } else if (c == '+') {
                res += sign * operand;
                sign = 1;
                operand = 0;
            } else if (c == '-') {
                res += sign * operand;
                sign = -1;
                operand = 0;
            } else if (c == '(') {
                num.push(res);
                num.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * operand;
                res *= num.pop(); //这个是之前的结果的符号
                res += num.pop(); //这个是之前的结果的值
                operand = 0;
            }
        }
        //最后一次把结果加上去
        return res + sign * operand;
    }


    public int calculate2(String s) {

        s = s.trim();
        return calc(s, 0, s.length());
    }

    //"(1+(4+5+2)-3)+(6+8)" + - （ ） 空格
    public int calc(String s, int start, int end) {

        if (s.charAt(start) == '(') {
            int right = findRight(s, start + 1, end);
            return calc(s, start + 1, right) + calc(s, right + 1, end);
        }
        int res = 0;
        int a = -1;
        int b = -1;
        int op = 0; // 1加 2减
        boolean ever = false;
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                int t = 0;
                int j = i;
                while (j < end && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    c = s.charAt(j);
                    int tt = c - '0';
                    t = t * 10 + tt;
                    j++;
                }
                i = j - 1;

                a = a == -1 ? t : a;
                b = a != -1 ? t : b;
                if (a != -1 && b != -1 && op != 0) {
                    int t1 = (op == 1 ? a + b : a - b);
                    res = t1;
                    //算完了 重置
                    a = res;
                    b = -1;
                    op = 0;
                    ever = true;
                }
            } else if (c == '+') {
                op = 1;
            } else if (c == '-') {
                op = 2;
            } else if (c == '(') {
                int r = findRight(s, i, end);
                int t = calc(s, i + 1, r);
                a = a == -1 ? t : a;
                b = a != -1 ? t : b;
                if (a != -1 && b != -1 && op != 0) {
                    int t1 = (op == 1 ? a + b : a - b);
                    res = t1;
                    //算完了 重置
                    a = res;
                    b = -1;
                    op = 0;
                    ever = true;
                }
                i = r;
            } else if (c == ')') {
                continue;
            }
        }
        return res + (ever == false ? a : 0);
    }

    private int findRight(String s, int start, int end) {

        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (c == ')') return i;
        }
        return s.length();
    }

    public static void main(String[] args) {

        Calculate m = new Calculate();
        int a = m.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(a);
    }
}
