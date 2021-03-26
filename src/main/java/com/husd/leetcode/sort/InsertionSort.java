package com.husd.leetcode.sort;

import java.util.Arrays;

/**
 * 直接插入排序的核心思想就是：
 * <p>
 * 将数组中的所有元素依次跟前面已经排好的元素相比较，
 * 如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过。
 */
public class InsertionSort {

    // 插入排序，a表示数组，n表示数组大小
    public void sort(int[] a, int n) {

        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            //先把value
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }

    public static void main(String[] args) {

        int[] a = {5, 4, 3, 2, 1};
        int n = a.length;
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(a, n);
        System.out.println(Arrays.toString(a));
    }
}
