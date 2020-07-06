package com.husd.leetcode.math;

/**
 * 65. 有效数字
 * <p>
 * 验证给定的字符串是否可以解释为十进制数字。
 * <p>
 * 例如:
 * <p>
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * <p>
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 * <p>
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 * <p>
 * 更新于 2015-02-10:
 * C++函数的形式已经更新了。如果你仍然看见你的函数接收 const char * 类型的参数，请点击重载按钮重置你的代码。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class IsNumber {

    //TODO 值得一看
    //有限自动机解法
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char arr[] = s.trim().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                numSeen = true;
            } else if (arr[i] == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (arr[i] == 'E' || arr[i] == 'e') {
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false;
            } else if (arr[i] == '+' || arr[i] == '-') {
                if (i != 0 && arr[i - 1] != 'e' && arr[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen;
    }

    public boolean isNumber2(String s) {

        if (s == null || s.length() == 0) return false;
        s = s.trim();
        if (s == null || s.length() == 0) return false;
        if (s.length() == 1) return valid(s.charAt(0));

        //前面的空格去了
        int start = 0;

        //if(start == s.length() - 1) return false;

        boolean point = false;

        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            start++;
        } else {
            if (!valid(s.charAt(0))) {
                if (s.charAt(0) == '.') {
                    point = true;
                    start++;
                } else {
                    return false;
                }
            }
            //start++;
        }

        //如果遇到了空格，那么后面就只能都是空格
        boolean space = false;
        for (int i = start; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '.' && point) {
                return false;
            }
            if (c == '.' && !point) {
                point = true;
            }
            //点的前后必须有数字
            if (c == '.') {
                if (!valid(s.charAt(i - 1))) {
                    return false;
                } else {
                    continue;
                }
            }
            //e 的前后必须有数字
            if (c == 'E' || c == 'e') {
                if (!valid(s.charAt(i - 1)) || (i + 1) == s.length() || !valid(s.charAt(i + 1))) {
                    return false;
                } else {
                    continue;
                }
            }

            if (c == 32 && !space) {
                space = true;
                continue;
            }

            if (c != 32 && space) return false;


            if (!valid(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean valid(char c) {

        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {

        IsNumber m = new IsNumber();
        m.isNumber("..");
    }
}
