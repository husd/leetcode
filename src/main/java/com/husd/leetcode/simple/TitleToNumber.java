package com.husd.leetcode.simple;

/**
 * 171. Excel表列序号
 * <p>
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @date 2020/3/30
 */
public class TitleToNumber {

    public int titleToNumber(String s) {

        char[] charArray = s.toCharArray();
        int target = 0;
        for (int i = 0; i < s.length(); i++) {
            target = target * 26 + (charArray[i] - 'A') + 1;
        }
        return target;
    }
}
