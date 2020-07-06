package com.husd.leetcode.math;

import java.util.Arrays;

/**
 * 891. 子序列宽度之和
 * <p>
 * 给定一个整数数组 A ，考虑 A 的所有非空子序列。
 * <p>
 * 对于任意序列 S ，设 S 的宽度是 S 的最大元素和最小元素的差。
 * <p>
 * 返回 A 的所有子序列的宽度之和。
 * <p>
 * 由于答案可能非常大，请返回答案模 10^9+7。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[2,1,3]
 * 输出：6
 * 解释：
 * 子序列为 [1]，[2]，[3]，[2,1]，[2,3]，[1,3]，[2,1,3] 。
 * 相应的宽度是 0，0，0，1，1，2，2 。
 * 这些宽度之和是 6 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 20000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-subsequence-widths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class SumSubseqWidths {

    //这道题在于把所有的子序列找出来
    // 只有1个元素，没有意义，差是0
    //
    //TODO 值得一看
    public int sumSubseqWidths(int[] A) {

        if (A.length == 1) return 0;
        if (A.length == 2) return Math.abs(A[0] - A[1]);

        int n = 3;
        Arrays.sort(A);
        int sum = 0;
        //有很多子集合的差值都是一样的，可以优化
        // 1 2 3 4 5 6 7 8 9 10
        while (n <= A.length) {

        }
        return 0;
    }
}
