package com.husd.leetcode.math;

/**
 * 面试题 17.04. 消失的数字
 * <p>
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * <p>
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,0,1]
 * 输出：2
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MissingNumber {

    // 思路就是 高斯和 - 实际的和 计算简单 性能也不错
    public int missingNumber(int[] nums) {

        int n = nums.length + 1;
        int target = n * (n + 1) / 2;
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
        return target - sum;
    }

    //思路2 利用异或的思想，利用 a ^ a = 0 a ^ 0 = 0
    //这2个公式，将nums中的数组和每一个数字异或，最后的值就是丢失的值
    public int missingNumber2(int[] nums) {

        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= n;
        return res;
    }

    public static void main(String[] args) {

        MissingNumber mn = new MissingNumber();
        int[] nums = {3, 0, 1};
        mn.missingNumber(nums);
    }
}
