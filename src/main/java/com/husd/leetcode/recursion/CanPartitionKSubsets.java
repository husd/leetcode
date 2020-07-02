package com.husd.leetcode.recursion;

/**
 * 698. 划分为k个相等的子集
 * <p>
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class CanPartitionKSubsets {

    //TODO 值得一看
    private boolean backtracking(int[] nums, int k, int avg, int cur, int start, boolean[] used) {
        // 返回条件
        if (k == 0) return true;
        //如果恰好有相等的，就直接找下一个，因为nums的数字都是大于0的，所以可以这么做
        //但是如果有负数，就不能这么做了
        if (cur == avg) {
            // 构建下一个集合
            return backtracking(nums, k - 1, avg, 0, 0, used);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cur + nums[i] <= avg) {
                used[i] = true;
                //找下一个值，看看能不能找到 可能有1个 或者2个 或者3个
                if (backtracking(nums, k, avg, cur + nums[i], i + 1, used)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 注意nums[i] > 0
        int sum = 0, maxNum = 0;
        for (int n : nums) {
            sum += n;
            maxNum = Math.max(maxNum, n);
        }
        //不能平均除 或者最大值比平均值还大，就说明不能分
        if (sum % k != 0 || maxNum > sum / k) return false;
        //用来存哪些索引已经用了，哪些没用
        boolean[] used = new boolean[nums.length];
        int avg = sum / k;
        return backtracking(nums, k, avg, 0, 0, used);
    }
}
