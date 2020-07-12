package com.husd.leetcode.hash;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RepeatedNTimes {

    //一旦找到一个重复元素，那么一定就是答案。我们称这个答案为主要元素。
    //
    //考虑所有长度为 4 的子序列，在子序列中一定至少含有两个主要元素。
    //
    //这是因为：
    //
    //长度为 2 的子序列中都是主要元素，或者；
    //每个长度为 2 的子序列都恰好含有 1 个主要元素，这意味着长度为 4 的子序列一定含有 2 个主要元素。
    //因此，只需要比较所有距离为 1，2 或者 3 的邻居元素即可。
    //
    public int repeatedNTimes(int[] A) {

        for (int k = 1; k <= 3; ++k) {
            for (int i = 0; i < A.length - k; ++i) {
                if (A[i] == A[i+k]) return A[i];
            }

        }

        return -1;
    }
}
