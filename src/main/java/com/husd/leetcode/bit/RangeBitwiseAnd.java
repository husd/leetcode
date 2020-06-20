package com.husd.leetcode.bit;

/**
 * 201. 数字范围按位与
 * <p>
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * <p>
 * 示例 1: 
 * <p>
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: [0,1]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @tag 位运算
 */
public class RangeBitwiseAnd {

    //这个算法题考啥呢？
    //
    public int rangeBitwiseAnd(int m, int n) {

        if (m == Integer.MAX_VALUE) {
            return m;
        }
        int res = m;
        for (int i = m + 1; i <= n; i++) {
            res &= i;
            if (res == 0 || i == Integer.MAX_VALUE) {
                break;
            }
        }
        return res;
    }

    //
    public int rangeBitwiseAnd2(int m, int n) {

        int z = 0;
        while (n > m) {

            z++;
            n = n >> 1;
            m = m >> 1;
        }
        return m << z;
    }

    // 对于任意一个数 n，然后 n & (n-1) 的结果就是把 n 的最右边的 1 置为 0
    public int rangeBitwiseAnd3(int m, int n) {

        while (n > m) {
            n = n & (n - 1);
        }
        return n;
    }
}
