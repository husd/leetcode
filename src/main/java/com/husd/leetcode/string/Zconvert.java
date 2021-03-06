package com.husd.leetcode.string;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @date 2020/3/27
 */
public class Zconvert {

    /**
     * 首先每行的第一个字母为位置为：row - 1
     *
     * 中间的每行的第二个字母位置为：2 * numRows - row - 1
     *
     * 每次循环的指针增量为：(numRows - 1) * 2
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {

        if(numRows == 1) {
            return s;
        }
        int space = (numRows - 1) * 2;
        char[] chars = s.toCharArray();
        char[] newchars = new char[chars.length];
        int i = 0;


        //TODO
        return null;
    }
}
