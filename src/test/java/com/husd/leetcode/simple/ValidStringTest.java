package com.husd.leetcode.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidStringTest {

    @Test
    public void isValid() {

        ValidString validString = new ValidString();

        System.out.println(validString.isValid("(){}[]"));
    }
}