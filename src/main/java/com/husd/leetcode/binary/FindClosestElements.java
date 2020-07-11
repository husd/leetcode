package com.husd.leetcode.binary;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 658. 找到 K 个最接近的元素
 *
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 *  
 *
 * 示例 2:
 *
 * 输入: [1,2,3,4,5], k=4, x=-1
 * 输出: [1,2,3,4]
 *  
 *
 * 说明:
 *
 * k 的值为正数，且总是小于给定排序数组的长度。
 * 数组不为空，且长度不超过 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 *  
 *
 * 更新(2017/9/19):
 * 这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。 请重新加载代码定义以获取最新更改。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-closest-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindClosestElements {

    //TODO 值得一看 稍微难了点
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> res = new ArrayList<>(k);

        int prev = 0;
        int last = arr.length - 1;
        if(x <= arr[0]) {
            prev = 0;
            last = k;
        } else if(x >= arr[arr.length -1]) {
            prev = arr.length - k;
            last = arr.length;
        } else {

            int start = 0;
            //先找到最接近x的下标
            int low=0,high = arr.length - 1;
            while(low <= high) {
                int mid = low + (high - low) /2;
                // 1 2 3 5 6 7 8
                if(arr[mid] == x) {
                    start = mid;
                    break;
                }
                if(mid - 1 >= 0 && arr[mid-1] <x && arr[mid] > x) {
                    int diff1 = x - arr[mid-1];
                    int diff2 = arr[mid] - x;
                    start =  diff1 > diff2 ? mid : mid - 1;
                    break;
                }
                if(mid + 1 <= high && arr[mid] < x && arr[mid+1] > x) {
                    int diff1 = x - arr[mid];
                    int diff2 = arr[mid+1] - x;
                    start =  diff1 > diff2 ? mid + 1 : mid;
                    break;
                }
                if(arr[mid] > x) {
                    high = mid;
                } else {
                    low = mid;
                }
            }

            prev = start;
            last = start + 1;

            int c = 0;
            while(c < k - 1) {
                int s = prev - 1;
                int end = last;
                int diff1 = s < 0 ? Integer.MAX_VALUE : Math.abs(arr[s]-x);
                int diff2 = end >= arr.length ? Integer.MAX_VALUE : Math.abs(arr[end] - x);
                if(diff1 == diff2) {
                    prev--;
                } else if(diff1 > diff2) {
                    last++;
                } else {
                    prev--;
                }
                c++;
            }
        }

       // prev = prev < 0? 0 : prev;
       // last = last > arr.length ? arr.length : last;

        while (prev < last) {

            res.add(arr[prev]);
            prev++;
        }
        return res;
    }

    public static void main(String[] args) {

        FindClosestElements m = new FindClosestElements();
        int [] arr = {1,2,3,4,5};
        List<Integer> a = m.findClosestElements(arr,4,3);
        System.out.println(a);
    }
}
