package com.husd.leetcode.math;

/**
 * 16.05. 阶乘尾数
 *
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-zeros-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @date 2020/3/30
 */
public class TrailingZeroes {

    // 阶乘中，末尾的0，说明有10  10 = 5 * 2 所以计算5和2的数量
    // 有5必有2 因为 5 * 4 10 * 8 15 * 14 = 5 * 3 * 7 * 2 所以计算有几个5就行了
    public int trailingZeroes(int n) {

        int target = 0;
        while(n > 0) {
            target += n / 5;
            n = n / 5;
        }
        return target;
    }
}
