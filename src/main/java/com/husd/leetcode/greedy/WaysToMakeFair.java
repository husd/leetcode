package com.husd.leetcode.greedy;

/**
 * 1664. 生成平衡数组的方案数
 * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 * <p>
 * 比方说，如果 nums = [6,1,7,4,1] ，那么：
 * <p>
 * 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 * 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 * 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 * <p>
 * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,6,4]
 * 输出：1
 * 解释：
 * 删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
 * 删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
 * 删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
 * 删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
 * 只有一种让剩余数组成为平衡数组的方案。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以删除任意元素，剩余数组都是平衡数组。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：不管删除哪个元素，剩下数组都不是平衡数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 * @author hushengdong
 */
public class WaysToMakeFair {

    //https://leetcode-cn.com/problems/ways-to-make-a-fair-array/solution/shuang-bai-zheng-fu-jiao-ti-qian-zhui-he-by-letian/
    public int waysToMakeFair(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n + 1];
        // dp[i]表示(0,1,2...,i-1)的奇偶数之差(偶数和-奇数和)
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + ((i & 1) == 0 ? nums[i - 1] : -nums[i - 1]);
        }
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            //当删除第 i 个元素后(下标 i-1)，此元素之前奇偶数之差为 dp[i-1](偶-奇)
            //此元素之后奇偶数之差为 dp[n]-dp[i](偶-奇)
            //由于删除 i 后，奇偶翻转，所以只需判断相等即可
            if (dp[i - 1] == dp[n] - dp[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        WaysToMakeFair waysToMakeFair = new WaysToMakeFair();
        int[] nums = {1, 1, 1};
        int res = waysToMakeFair.waysToMakeFair(nums);
        System.out.println(res);
    }
}
