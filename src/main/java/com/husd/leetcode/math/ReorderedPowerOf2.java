package com.husd.leetcode.math;

import java.util.Arrays;

/**
 * 869. 重新排序得到 2 的幂
 * <p>
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * <p>
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：10
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：16
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：24
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：46
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reordered-power-of-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class ReorderedPowerOf2 {

    //这题没意思 不看也罢
    public boolean reorderedPowerOf(int n) {

        //先看n 是几位数
        int[] A = count(n);
        for (int i = 0; i < 31; ++i)
            if (Arrays.equals(A, count(1 << i)))
                return true;
        return false;
    }

    // Returns the count of digits of N
    //返回的数组，表示的是 0-9的数字在N中出现的次数 如果和2的幂次方一样
    //就表示可以转换成2的幂次方
    // Eg. N = 112223334, returns [0,2,3,3,1,0,0,0,0,0]
    public int[] count(int N) {
        int[] ans = new int[10];
        while (N > 0) {
            ans[N % 10]++;
            N /= 10;
        }
        return ans;
    }

    //判断是2个幂
    private boolean ok(int n) {

        return n > 0 && (n & n - 1) == 0;
    }

    public static void main(String[] args) {

        ReorderedPowerOf2 m = new ReorderedPowerOf2();
        System.out.println(m.ok(64));
    }
}
