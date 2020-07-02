package com.husd.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 726. 原子的数量
 * <p>
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 * <p>
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * <p>
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 * <p>
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 * <p>
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * <p>
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 * 示例 2:
 * <p>
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 * 示例 3:
 * <p>
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 * 注意:
 * <p>
 * 所有原子的第一个字母为大写，剩余字母都是小写。
 * formula的长度在[1, 1000]之间。
 * formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-atoms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class CountOfAtoms {

    Map<String, Integer> m = new HashMap<>();

    //递归写法
    public String countOfAtoms(String formula) {

        count(formula, 0, formula.length(), 1);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            int count = entry.getValue();
            String str = entry.getKey();
            sb.append(str);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    //K4(ON(SO3)2)2
    private int count(String formula, int start, int end, int index) {

        for (int i = start; i < end; i++) {
            char c = formula.charAt(i);
            if (bigC(c)) {
                //如果是大写字母，就找到它的结束
                if (i == (end - 1)) {
                    String str = String.valueOf(c);
                    int c1 = 1;
                    c1 = c1 * index;
                    int c2 = m.getOrDefault(str, 0);
                    m.put(str, c1 + c2);
                    return i + 1;
                }
                int j1 = 0;
                for (int j = i + 1; j < end; j++) {
                    // 结束有几种情况 数字 ( 另外一个大写字母
                    boolean a= (j == (end - 1)) || bigC(formula.charAt(j)) ;
                    int c1 = a ? 1 : getCount(formula.charAt(j));
                    if (c1 > 0) {
                        String str = a ? String.valueOf(c) : formula.substring(i, j - 1);
                        c1 = c1 * index;
                        int c2 = m.getOrDefault(str, 0);
                        m.put(str, c1 + c2);
                        j1 = j;
                        break;
                    }
                }
                //走下一步
                if (isNum(formula.charAt(j1))) {
                    i = count(formula, j1 + 1, end, 1);
                } else if (bigC(formula.charAt(j1))) {
                    i = count(formula, j1, end, 1);
                } else if (left(formula.charAt(j1))) {
                    i = count(formula, j1, end, 1);
                }
            } else if (left(c)) {
                //找到右括号 //K4(ON(SO3)2)2H2
                for (int j = i + 1; j < end; j++) {
                    if (right(formula.charAt(j))) {
                        int index1 = char2Num(formula.charAt(j + 1));
                        count(formula, i + 1, j - 1, index1);
                        i = count(formula, j + 2, end, 1);
                    }
                }
            }
        }
        return end;
    }

    private int getCount(char c) {

        if (isNum(c)) return char2Num(c);
        if (bigC(c)) return 1;
        return 0;
    }

    private int char2Num(char c) {

        return c - '0';
    }

    private boolean left(char c) {

        return c == '(';
    }

    private boolean right(char c) {

        return c == ')';
    }

    private boolean bigC(char c) {

        return c >= 'A' && c <= 'Z';
    }

    private boolean isNum(char c) {

        return c >= '2' && c <= '9';
    }

    public static void main(String[] args) {

        CountOfAtoms m = new CountOfAtoms();
        m.countOfAtoms("Mg(OH)2");
    }
}
