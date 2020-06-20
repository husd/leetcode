package com.husd.leetcode.string;

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
       // String target = s.substring(0, 1);
        char [] charArray = s.toCharArray();
        int _start = 0;
        int _end = 0;
        for (int start = 0; start < s.length() - 1; start++) {
            // abcdefg
            for(int index = start +1;index<s.length();index++) {
                boolean ok = isOk(start,index,charArray);
                if(ok) {
                    int _len = index - start + 1;
                    if(_len >= max) {
                        _start = start;
                        _end = index;
                        max = _len;
                    }
                    if(max == s.length() - start) {
                        return getOkStr(_start,_end,s);
                    }
                } else {
                    //System.out.println("false :" + getOkStr(start,index,s));
                }
            }
        }
        return getOkStr(_start,_end,s);
    }

    public String getOkStr(int start,int end ,String s) {
        return s.substring(start, end == s.length() ? end : end + 1);
    }

    public boolean isOk(int start, int end, char [] charArray) {

        if (start == end) return false;
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
