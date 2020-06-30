package com.husd.leetcode.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 1297. 子串的最大出现次数
 * <p>
 * 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
 * <p>
 * 子串中不同字母的数目必须小于等于 maxLetters 。
 * 子串的长度必须大于等于 minSize 且小于等于 maxSize 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * 输出：2
 * 解释：子串 "aab" 在原字符串中出现了 2 次。
 * 它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
 * 示例 2：
 * <p>
 * 输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * 输出：2
 * 解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。
 * 示例 3：
 * <p>
 * 输入：s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
 * 输出：3
 * 示例 4：
 * <p>
 * 输入：s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * 1 <= maxLetters <= 26
 * 1 <= minSize <= maxSize <= min(26, s.length)
 * s 只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-occurrences-of-a-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class MaxFreq {

    //常规思路 暴力解法
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                int len = j - i;
                if (len < minSize) {
                    continue;
                }
                if (len > maxSize) {
                    break;
                }
                if (len <= maxLetters || lessThenMaxLetters(s, i, j, maxLetters)) {
                    String str = s.substring(i, j);
                    int c = map.getOrDefault(str, 0);
                    c++;
                    map.put(str, c);
                    res = Math.max(res, c);
                }
            }
        }
        return res;
    }

    //字符串去重复之后的数字
    //不再首先考虑map了?
    private boolean lessThenMaxLetters(String s, int i, int j, int maxLetters) {

        int res = 0;
        for (; i < j; i++) {
            int a = (int) s.charAt(i) - 97;
            res |= (1 << a);
        }
        return Integer.bitCount(res) <= maxLetters;
    }

    public static void main(String[] args) {

        MaxFreq maxFreq = new MaxFreq();

        maxFreq.maxFreq("aababcaab", 2, 3, 4);
        //maxFreq.lessThenMaxLetters("caaa", 0, 3, 2);
    }
}
