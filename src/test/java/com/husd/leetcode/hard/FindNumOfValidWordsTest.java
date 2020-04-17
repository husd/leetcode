package com.husd.leetcode.hard;

import org.junit.Test;

public class FindNumOfValidWordsTest {

    @Test
    public void findNumOfValidWords() {
    }

    @Test
    public void toInt() {

        FindNumOfValidWords findNumOfValidWords = new FindNumOfValidWords();
        int a = 0;
        String str = "abd";
        for (int i = 0; i < str.length(); i++) {
            a |= 1 << (str.charAt(i) - 'a');
        }
        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));
    }
}