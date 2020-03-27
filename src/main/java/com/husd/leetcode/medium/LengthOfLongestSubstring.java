package com.husd.leetcode.medium;

/**
 *
 * 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @create 2019-11-04 10:32:00
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int[] mOccur = new int[256];
        int maxL = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            //拿到该字符串
            char ch = s.charAt(i);
            //把标志位加1
            ++mOccur[ch];
            //mOccur[ch] > 1 表示该字符串第2次出现了，说明要计算下本次循环的最长
            //怎么计算呢？
            while (mOccur[ch] > 1) {
                --mOccur[s.charAt(j++)];
            }
            maxL = Math.max(maxL, i - j + 1);
        }
        return maxL;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.equals(" ")) return 1;
        int[] exist = new int[128];
        int max = 1;
        int start = 0;
        exist[s.charAt(start)] = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (exist[c] == (start + 1)) {
                //重复了，计算长度，然后下一个
                int length = i - start;
                max = max > length ? max : length;
                //把索引重置为下一个
                i = start++;
            } else {
                //没有重复，继续走，找下一个
                exist[c] = (start + 1);
            }
        }
        int len = s.length() - start;
        max = max > len ? max : len;
        return max;
    }

}
