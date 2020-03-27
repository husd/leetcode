package com.husd.leetcode.medium;

/**
 * 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @date 2020/3/27
 */
public class LongestPalindrome {

    //初步的动态规划，2维数组记录之前的结果
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() < 2) return s;
        int[] exist = new int[128];

        //TODO
        return null;
    }

}
