package com.husd.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class A2ITest {

    @Test
    public void myAtoi() {

        A2I a = new A2I();
        System.out.println(a.myAtoi("2147483648"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}