package com.husd.leetcode.bit;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidUtf8Test {

    @Test
    public void validUtf8() {

        int [] arr = {145};
        ValidUtf8 validUtf8 = new ValidUtf8();
        System.out.printf("ans is : "+validUtf8.validUtf8(arr));
    }
}