package com.husd.leetcode.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 761. 特殊的二进制序列
 * <p>
 * hard
 * <p>
 * 特殊的二进制序列是具有以下两个性质的二进制序列：
 * <p>
 * 0 的数量与 1 的数量相等。
 * 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
 * 给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作 为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。（两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)
 * <p>
 * 在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "11011000"
 * 输出: "11100100"
 * 解释:
 * 将子串 "10" （在S[1]出现） 和 "1100" （在S[3]出现）进行交换。
 * 这是在进行若干次操作后按字典序排列最大的结果。
 * 说明:
 * <p>
 * S 的长度不超过 50。
 * S 保证为一个满足上述定义的特殊 的二进制序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/special-binary-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class MakeLargestSpecial {

    //TODO 值得一看

    //这题的题意很有问题，简直是不说人话
    //特殊的字符串，除了1和0的数量相等外 还说明1和0是相对的
    //可以把1比做（ 0比做 ）这样这个字符串必定是 : ()(())()(((())))这样的
    //你选择的字串，也必须是特殊的字串，这就限制了如何去拆分这个特殊的字串

    //是不是联想到了 编译器的括号匹配

    public String makeLargestSpecial(String str) {

        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();

        //注意这个count的设计，精妙 在另外一个计算众树的题目中，也有类似的设计
        int count = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            count += str.charAt(i) == '1' ? 1 : -1;
            if (count == 0) {
                String s1 = str.substring(start + 1, i);
                //下面这行代码，才是本题的解题的关键，就是先找出2边的 10 然后把中间的作为1个子问题，然后
                //递归的解析子问题
                res.add('1' + makeLargestSpecial(s1) + '0');
                start = i + 1;
            }
        }
        //排序
        Collections.sort(res);
        for (int i = res.size() - 1; i >= 0; i--) {
            sb.append(res.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        MakeLargestSpecial m = new MakeLargestSpecial();
        m.makeLargestSpecial("11011000");
    }
}
