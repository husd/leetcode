package com.husd.leetcode.reverse;

import java.util.Stack;

/**
 * 中序式转后序式
 * (a+b)*(c+d)这个式子，表示为后序表示式时是ab+cd+*
 * <p>
 * a+(b+c)*d : bc+d*a+ bcda+*+
 * <p>
 * 中序表达式
 * 1、操作数就直接入栈 输出栈
 * 2、操作符入操作符栈之前与栈顶操作符比较 如果当栈顶优先级高于或等于当前操作符，就出栈 进入输出栈
 * 3、'('直接入栈操作符栈
 * 4、')'出栈（）之间的操作符 到输出栈
 *
 * @author hushengdong
 */
public class Postfix {

    public String postfix(String str) {

        //符号栈
        Stack<Character> opStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (Character c : str.toCharArray()) {
            if (isOP(c)) {
                if (c == '(') {
                    // 如果操作符是左括号，直接推入栈
                    opStack.push(c);
                } else if (c == ')') {
                    //如果操作符是右括号，则往前找左括号，
                    // 将左括号之后的操作符放到后续表达式列表中
                    char temp = opStack.pop();
                    while (temp != '(') {
                        sb.append(temp);
                        temp = opStack.pop();
                    }
                } else {
                    // 看栈顶元素，
                    // 如果它优先级大于等于当前操作符的优先级，
                    // 则弹出放到后续表达式列表中
                    while (opStack.size() > 0 && (getOpLevel(opStack.peek()) >= getOpLevel(c))) {
                        sb.append(opStack.pop());
                    }
                    opStack.push(c);
                }
            } else {
                sb.append(c);
            }
        }
        // 将栈中余下的操作符弹出放到后续表达式列表中
        while (!opStack.isEmpty()) {
            sb.append(opStack.pop());
        }
        return sb.toString();
    }

    private int getOpLevel(char c) {

        if (c == '*') return 3;
        if (c == '/') return 3;
        if (c == '+') return 2;
        if (c == '-') return 2;
        return -1;
    }

    public boolean isOP(char c) {

        if (c == '*') return true;
        if (c == '/') return true;
        if (c == '+') return true;
        if (c == '-') return true;
        if (c == '(') return true;
        if (c == ')') return true;
        return false;
    }

    public static void main(String[] args) {

        Postfix postfix = new Postfix();
        String s1 = "(a+b)*(c+d)";
        String s2 = "a+b*c+d";
        String s3 = "a+b*(c+e)+d";
        System.out.println(s1 + " 解析后: " + postfix.postfix(s1));
        System.out.println(s2 + " 解析后: " + postfix.postfix(s2));
        System.out.println(s3 + " 解析后: " + postfix.postfix(s3));
    }
}
