package com.husd.leetcode.sort;

import java.util.Arrays;

/**
 * @author hushengdong
 */
public class SimpleSelectSort {

    // 插入排序，a表示数组，n表示数组大小
    public static void sort(int[] a, int n) {

        for (int i = 0; i < n - 1; i++) {

            int minInx = i + 1;
            for (int j = minInx + 1; j < n; j++) {
                if (a[j] < a[minInx]) {
                    minInx = j;
                }
            }
            if (a[minInx] < a[i]) {
                //待排序的队列，小于第一个值，交换
                int temp = a[i];
                a[i] = a[minInx];
                a[minInx] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[] a = {5, 4, 3, 2, 1, 6, 7, 10, 8, 9};
        int n = a.length;
        SimpleSelectSort.sort(a, n);
        System.out.println(Arrays.toString(a));
    }
}
