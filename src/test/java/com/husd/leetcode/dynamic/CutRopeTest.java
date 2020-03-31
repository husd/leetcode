package com.husd.leetcode.dynamic;

import org.junit.Test;

public class CutRopeTest {

    @Test
    public void cut() {

        CutRope cutRope = new CutRope();
        System.out.println(cutRope.cut(8));
        System.out.println(cutRope.cut(9));
        System.out.println(cutRope.cut(100));
    }
}