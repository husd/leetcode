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

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() < 2) return s;
        int max = 2;
        String target = s.substring(0, 1);
        for (int start = 0; start < s.length() - 1; start++) {
            // abcdefg
            for(int index = start +1;index<s.length();index++) {
                String ok = isOk(start,index,s);
                if(ok.length() > 0 && ok.length() >= max) {
                    max = ok.length();
                    target = ok;
                }
            }
        }
        return target;
    }

    public String isOk(int start, int end, String s) {

        int _start = start;
        int _end = end;
        if (start == end) return "";
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                //System.out.println("false start : " + _start + " end:" + _end + " s:" + s.substring(_start, _end == s.length() ? _end : _end + 1));
                return "";
            }
            start++;
            end--;
        }
        String ok = s.substring(_start, _end == s.length() ? _end : _end + 1);
        //System.out.println("success start : " + _start + " end:" + _end + " s:" + ok);
        return ok;
    }

    private boolean sameStr(int start, int end, String s) {

        int _s1 = start;
        int _s2 = end;
        char _s = s.charAt(start);
        while (start < end) {
            if (s.charAt(++start) != _s) {
                //  System.out.println("----2 start:" + _s1 + " -- end:" + _s2 + " s:" + s + " false");
                return false;
            }
        }
        //  System.out.println("----3 start:" + _s1 + " -- end:" + _s2 + " s:" + s + " true");
        return true;
    }

}
