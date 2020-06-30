package com.husd.leetcode.bit;

/**
 * 1318. 或运算的最小翻转次数
 * <p>
 * 给你三个正整数 a、b 和 c。
 * <p>
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 * <p>
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：a = 2, b = 6, c = 5
 * 输出：3
 * 解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
 * 示例 2：
 * <p>
 * 输入：a = 4, b = 2, c = 7
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：a = 1, b = 2, c = 3
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-flips-to-make-a-or-b-equal-to-c
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class MinFlips {

    public int minFlips(int a, int b, int c) {

        int a1 = a | b;
        int a2 = a1 ^ c;
        //不一样的位的数量 有3种情况
        //1 a = 1 b = 1 c = 0 反转2次
        //2 a = 0 b = 1 c = 0 反转1次
        //3 a = 0 b = 0 c = 1 反转1次
        // 所以 res = a2的1的个数 + 1这种情况
        // Integer.bitCount(a2) 表示a2的1的个数，直接可以算出来

        int diff = Integer.bitCount(a2);
        //剩下的就是计算 a = 1 b = 1 并且 c = 0有多少个位

        // a&b 计算了a =1 b=1
        int a3 = a & b;
        // a3 & c 修改了C之中的其它位，例如 a4 = 010 c = 101 这种情况，n = 1
        //所以要先把c的值中，2边的1变成0，010 & 101 = 000 010 ^ 000 就是 a =1 b=1 c=0的数量
        int a4 = a3 & c;
        int a5 = a3 ^ a4;
        int n = Integer.bitCount(a5);
        return diff + n;
    }

    public static void main(String[] args) {

        MinFlips minFlips = new MinFlips();

        minFlips.minFlips(2, 6, 5);
    }
}
