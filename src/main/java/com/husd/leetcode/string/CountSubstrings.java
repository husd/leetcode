package com.husd.leetcode.string;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSubstrings {

    //暴力方法 这方法就是简单粗暴
    //复杂度O(N^2)
    public int countSubstrings1(String S) {

        int N = S.length(), ans = 0;
        //可能的回文的中心有 2N-1个， N个字母 + n-1 个字母的中间位置
        for(int i= 0;i<= 2 * N - 1;++i) {

            int left = i / 2;
            int right = left + i % 2;
            while(left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    // 首先把字符串改造一下，例如 aba 改造成 #a#b#a#
    public int countSubstrings(String S) {

        return 0;
    }
}
