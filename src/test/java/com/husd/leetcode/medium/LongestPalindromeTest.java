package com.husd.leetcode.medium;

import com.husd.leetcode.string.LongestPalindrome;
import org.junit.Test;

public class LongestPalindromeTest {

    @Test
    public void longestPalindrome() {

        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String str = longestPalindrome.longestPalindrome("bb");
        System.out.println(str);
    }
}