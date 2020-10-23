package com.husd.leetcode.sort;

public class QuickSort {

    private static void quickSort(int[] a, int head, int tail) {

        int low = head;
        int high = tail;
        int pivot = a[low];
        if (low < high) {

            while (low < high) {
                while (low < high && pivot <= a[high]) high--;
                a[low] = a[high];
                while (low < high && pivot >= a[low]) low++;
                a[high] = a[low];
            }
            a[low] = pivot;

            if (low > head + 1) quickSort(a, head, low - 1);
            if (high < tail - 1) quickSort(a, high + 1, tail);
        }

    }
}
