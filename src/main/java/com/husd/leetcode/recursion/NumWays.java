package com.husd.leetcode.recursion;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class NumWays {

    //其实可以用动态规划来做 不用递归
    public int numWays(int n) {

        if(n==0) return 1;
        if(n==1) return 1;
        if(n==2) return 2;
        int[] res = new int[100];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < 100; i++) {
            res[i] = (res[i-1] + res[i - 2]) % 1000000007;
        }
        return res[n-1];
    }
}
