package com.husd.leetcode.binary;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class MissingNumber {

    // 0 1 3 3 假设不缺数字，nums[i] = i
    // 现在缺了数字，导致 nums[i] = i + 1
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (mid == nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {

        MissingNumber m = new MissingNumber();
        int[] arr = {1, 2};
        int a = m.missingNumber(arr);
        System.out.println(a);
    }
}
