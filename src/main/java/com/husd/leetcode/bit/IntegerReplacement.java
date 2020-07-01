package com.husd.leetcode.bit;

/**
 * 397. 整数替换
 * <p>
 * 给定一个正整数 n，你可以做如下操作：
 * <p>
 * 1. 如果 n 是偶数，则用 n / 2替换 n。
 * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 * n 变为 1 所需的最小替换次数是多少？
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 8
 * <p>
 * 输出:
 * 3
 * <p>
 * 解释:
 * 8 -> 4 -> 2 -> 1
 * 示例 2:
 * <p>
 * 输入:
 * 7
 * <p>
 * 输出:
 * 4
 * <p>
 * 解释:
 * 7 -> 8 -> 4 -> 2 -> 1
 * 或
 * 7 -> 6 -> 3 -> 2 -> 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class IntegerReplacement {

    //递归写法 简单明了
    public int integerReplacement(int n) {

        if (n == Integer.MAX_VALUE)
            return 32;
        if (n <= 3)
            return n - 1;
        if ((n & 1) == 0)
            return integerReplacement(n / 2) + 1;
        else
            return Math.min(integerReplacement(n - 1), integerReplacement(n + 1)) + 1;
    }
}
