package com.husd.leetcode;

import org.junit.Test;

public class SomeTest {

    @Test
    public void test() {

        int a=10;
        int b = a;
        System.out.println(" a is:" + a + " b is :" + b);
        a = 20;
        System.out.println(" a is:" + a + " b is :" + b);

        Object a1 = new Object();
        Object b1 = a1;
        System.out.println(" a1 is:" + a1 + " b1 is :" + b1);
        a1 = new Object();
        System.out.println(" a1 is:" + a1 + " b1 is :" + b1);
    }
}
