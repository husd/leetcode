package com.husd.leetcode.math;

/**
 * 1015. 可被 K 整除的最小整数
 * <p>
 * 给定正整数 K，你需要找出可以被 K 整除的、仅包含数字 1 的最小正整数 N。
 * <p>
 * 返回 N 的长度。如果不存在这样的 N，就返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：1
 * 输出：1
 * 解释：最小的答案是 N = 1，其长度为 1。
 * 示例 2：
 * <p>
 * 输入：2
 * 输出：-1
 * 解释：不存在可被 2 整除的正整数 N 。
 * 示例 3：
 * <p>
 * 输入：3
 * 输出：3
 * 解释：最小的答案是 N = 111，其长度为 3。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-integer-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class SmallestRepunitDivByK {

    //仅包含数字1 ，就是1 111 1111 这样的数字
    // 偶数肯定是不行 只能是奇数
    // 这是个数学问题，记住即可
    //TODO 一般
    public int smallestRepunitDivByK(int K) {

        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        int temp = 1;
        int len = 1;
        while (temp % K != 0) {
            temp = temp % K;
            temp = temp * 10 + 1;
            len += 1;
        }
        return len;
    }

    public static void main(String[] args) {

        SmallestRepunitDivByK m = new SmallestRepunitDivByK();
        int a = m.smallestRepunitDivByK(5);
        System.out.println(a);
    }
}
