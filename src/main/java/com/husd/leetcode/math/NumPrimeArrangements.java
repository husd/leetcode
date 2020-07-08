package com.husd.leetcode.math;

/**
 * 1175. 质数排列
 * <p>
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 * <p>
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 * <p>
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 * 示例 2：
 * <p>
 * 输入：n = 100
 * 输出：682289015
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-arrangements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class NumPrimeArrangements {

    //直接撸出100以内的25个质数，计算n以内质数的个数和合数的个数
    //然后质数全排列乘以合数全排列，在计算时要及时取模防止溢出
    public int numPrimeArrangements(int n) {

        int MOD = 1_000_000_007;
        int[] zhishu = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
                83, 89, 97
        };
        //计算质数个数
        int m = 0;
        for (int c : zhishu) {
            if (n >= c) {
                m++;
            }
        }
        //计算非质数的个数
        int m1 = n - m;
        long ans = 1;

        //计算质数的全排列 * 非质数的全排列
        for (int i = m1; i > 1; i--) {
            if (ans < MOD / i) {
                ans *= i;
            } else {
                ans = ans * i % MOD;
            }
        }
        for (int i = m1; i > 1; i--) {
            if (ans < MOD / i) {
                ans *= i;
            } else {
                ans = ans * i % MOD;
            }
        }
        return (int) ans % MOD;
    }
}
