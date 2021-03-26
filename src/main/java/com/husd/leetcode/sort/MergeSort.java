package com.husd.leetcode.sort;

import java.util.Arrays;

/**
 * @author hushengdong
 */
public class MergeSort {

    //先拆分成2个，然后保证2个有序
    private static void sort(int[] a, int low, int high, int[] tmp) {

        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, low, mid, tmp);
        sort(a, mid + 1, high, tmp);
        merge(a, low, mid, high, tmp);
    }

    private static void merge(int[] a, int low, int mid, int high, int[] tmp) {

        int l = low;
        int r = mid + 1;
        int inx = low;
        while (l < mid && r <= high) {

            if (a[l] < a[r]) {
                tmp[inx] = a[l++];
            } else {
                tmp[inx] = a[r++];
            }
            inx++;
        }
        while (l < mid) {
            tmp[inx++] = a[l++];
        }
        while (r <= high) {
            tmp[inx++] = a[r++];
        }
        while (inx > low) {
            a[inx] = tmp[inx];
            inx--;
        }
    }

    public static void main(String[] args) {

        int[] a = {5, 4, 3, 2, 10, 6, 7, 1, 8, 9};
        int[] tmp = new int[a.length];
        int n = a.length;
        MergeSort.sort(a, 0, n - 1, tmp);
        System.out.println(Arrays.toString(a));
    }
}
