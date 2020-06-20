package com.husd.leetcode.simple;

import com.husd.leetcode.regex.ValidString;
import org.junit.Test;

public class ValidStringTest {

    @Test
    public void isValid() {

        ValidString validString = new ValidString();

        System.out.println(validString.isValid("(){}[]"));
    }
}