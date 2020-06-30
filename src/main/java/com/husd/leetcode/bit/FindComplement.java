package com.husd.leetcode.bit;

/**
 * 476. 数字的补数
 * <p>
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: 2
 * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2:
 * <p>
 * 输入: 1
 * 输出: 0
 * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *  
 * <p>
 * 注意:
 * <p>
 * 给定的整数保证在 32 位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class FindComplement {

    public int findComplement(int num) {

        if (num == 0) return 1;
        if (num == 1) return 0;
        int n = 0;
        int a = num;
        while (a > 0) {
            n++;
            a = a >> 1;
        }
        //掩码都是11111这种形势 具体有几个1 ，就看这个数字的2进制有几个长度了
        // 101 ^ 010 = 111
        // 010 ^ 101 = 111
        // 111 ^ 010 = 101
        // 111 ^ 101 = 010
        //通过以上这几个等式，思考可以得到什么结论呢? 思考下
        int mask = (int) Math.pow(2, n) - 1;
        mask |= 1;
        return mask ^ num;
    }

    public static void main(String[] args) {

        FindComplement findComplement = new FindComplement();
        int n = 5;
        int n1 = ~n;
        findComplement.findComplement(2147483647);
    }
}
