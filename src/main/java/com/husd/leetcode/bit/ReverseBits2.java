package com.husd.leetcode.bit;

/**
 * 面试题 05.03. 翻转数位
 * <p>
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 示例 2：
 * <p>
 * 输入: num = 7(01112)
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class ReverseBits2 {

    //思路比解题重要
    //解决一个问题，先抽象化，这个问题是要解决什么呢?
    //暴力方法其实就可以了?
    //从左到右挨个找?
    public int reverseBits(int num) {

        if (num == 0) return 1;
        int res = 0;
        int pre = 0;
        int count = 0;
        while (num != 0) {
            boolean zero = (num & 1) == 0;
            if (zero) {
                res = Math.max(res, count + pre + 1);
                pre = count;
                count = 0;
            } else {
                count++;
            }
            num = num >> 1;
        }
        res = Math.max(res, pre + count + 1);
        return res;
    }

    public static void main(String[] args) {

        ReverseBits2 a = new ReverseBits2();
        a.reverseBits(2147483647);
    }
}
