package com.husd.leetcode.sort;

import java.util.Arrays;

public class QuickSort {

    //快速排序 分治办法
    private static void sort(int[] a, int head, int tail) {

        int low = head;
        int high = tail;
        //pivot 就是基准值，比它小的放左边，比它大的放右边
        int pivot = a[low];
        if (low < high) {

            while (low < high) {
                while (low < high && pivot <= a[high]) {
                    high--;
                }
                a[low] = a[high];
                while (low < high && pivot >= a[low]) {
                    low++;
                }
                a[high] = a[low];
            }
            a[low] = pivot;

            if (low > head + 1) sort(a, head, low - 1);
            if (high < tail - 1) sort(a, high + 1, tail);
        }
    }

    public static void main(String[] args) {

        int[] a = {5, 4, 3, 2, 10, 6, 7, 1, 8, 9};
        int n = a.length;
        QuickSort.sort(a, 0, n - 1);
        System.out.println(Arrays.toString(a));
    }
}
