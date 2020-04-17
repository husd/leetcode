package com.husd.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

public class MergeTest {

    @Test
    public void merge() {
    }

    @Test
    public void mergeSort() {

        int[] array = {11, 2, 3, 4, 5, 6};
        Arrays.sort(array);
        Arrays.stream(array).forEach(a -> {
            System.out.print(" " + a);
        });
    }
}