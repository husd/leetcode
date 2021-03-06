package com.husd.leetcode.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * 898. 子数组按位或操作
 * <p>
 * 我们有一个非负整数数组 A。
 * <p>
 * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
 * <p>
 * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0]
 * 输出：1
 * 解释：
 * 只有一个可能的结果 0 。
 * 示例 2：
 * <p>
 * 输入：[1,1,2]
 * 输出：3
 * 解释：
 * 可能的子数组为 [1]，[1]，[2]，[1, 1]，[1, 2]，[1, 1, 2]。
 * 产生的结果为 1，1，2，1，3，3 。
 * 有三个唯一值，所以答案是 3 。
 * 示例 3：
 * <p>
 * 输入：[1,2,4]
 * 输出：6
 * 解释：
 * 可能的结果是 1，2，3，4，6，以及 7 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 50000
 * 0 <= A[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-ors-of-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @tag 位运算
 */
public class SubarrayBitwiseORs {

    public int subarrayBitwiseORs(int[] A) {

        Set<Integer> resu = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            resu.add(A[i]);
            for (int j = i -1 ; j >= 0; j--) {
                //关键代码 就是这行进行剪枝，后面的循环没必要进行计算了
                if((A[j] & A[i]) == A[i]) break;
                A[j] |= A[i];
                resu.add(A[j]);
            }
        }
        return resu.size();
    }
}
