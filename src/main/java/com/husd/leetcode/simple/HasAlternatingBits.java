package com.husd.leetcode.simple;

/**
 * 693. 交替位二进制数
 * <p>
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * 示例 2:
 * <p>
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * 示例 3:
 * <p>
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 *  示例 4:
 * <p>
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @tag 位运算
 */
public class HasAlternatingBits {

    public boolean hasAlternatingBits(int n) {

        int temp = n ^ (n >> 1);
        return (temp & (temp + 1)) == 0;
    }
}
