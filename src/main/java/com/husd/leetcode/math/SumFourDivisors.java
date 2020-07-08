package com.husd.leetcode.math;

/**
 * 1390. 四因数
 *
 * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。
 *
 * 如果数组中不存在满足题意的整数，则返回 0 。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [21,4,7]
 * 输出：32
 * 解释：
 * 21 有 4 个因数：1, 3, 7, 21
 * 4 有 3 个因数：1, 2, 4
 * 7 有 2 个因数：1, 7
 * 答案仅为 21 的所有因数的和。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/four-divisors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class SumFourDivisors {

    //本质是求因子 恰好是4个
    //要有2个素数的乘积  或者 立方
    // 21 = 3 7 1 21 素数
    // 8 = 2 4 1 8   立方
    //TODO 可以看看 这题有点难
    public int sumFourDivisors(int[] nums) {

        return 0;
    }
}
