package com.husd.leetcode.bit;

/**
 * 面试题 05.04. 下一个数
 * <p>
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出：[4, 1] 或者（[0b100, 0b1]）
 * 示例2:
 * <p>
 * 输入：num = 1
 * 输出：[2, -1]
 * 提示:
 * <p>
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closed-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class FindClosedNumbers {

    //重要的是思路
    // 0101010111 如果要减小数字，1的个数还要相等，相当于要移动1的位置 即要把最右边的1，设置为0，同时把最右边的0，设置为1
    // 如果要增加，反之
    public int[] findClosedNumbers(int num) {

        int[] res = new int[2];

        String s = Integer.toBinaryString(num);
        if (s.length() < 31) {
            s = "0" + s;
        }
        int len = s.length();
        int i = 0;
        int mask_a = -1, mask_b = -1;
        int res1 = -1, res2 = -1;
        boolean f1 = false, f2 = false;
        int c = 0;
        while (i < len - 1) {
            c++;
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1' && !f1) {
                // 最靠近的1个比num大的值 从右往左，找到第一个 01 位置，然后把 01 转为 10，右侧剩下的 1 移到右侧的低位，右侧剩下的位清0。
                mask_a = setLow0(num, len - i);
                mask_a = setPos1(mask_a, len - i);
                mask_a = setPos0(mask_a, len - i - 1);
                int temp = (num >> (c + 1)) << (c + 1);
                temp = temp <= 0 ? 0 : temp;
                int count1 = popCount(temp);
                res1 = mask_a + (count1 > 0 ? (1 << (count1 + 1) - 1) << c : 0);
                res1 = res1 <= 0 ? -1 : res1;
                f1 = true;
            }
            if (s.charAt(i) == '1' && s.charAt(i + 1) == '0' && !f2) {
                // 比 num 小的数：从右往左，找到第一个 10 位置，然后把 10 转为 01，右侧剩下的 1 移到右侧的高位，右侧剩下的位置0。
                mask_b = setLow0(num, len - i);
                mask_b = setPos0(mask_b, len - i);
                mask_b = setPos1(mask_b, len - i - 1);
                int temp = (num >> (c + 1)) << (c + 1);
                temp = temp <= 0 ? 0 : temp;
                int count1 = popCount(temp);
                res2 = mask_b + (count1 > 0 ? (1 << (count1 + 1)) - 1 : 0);
                res2 = res2 <= 0 ? -1 : res2;
                f2 = true;
            }
            i++;
            if (f1 && f2) {
                break;
            }
        }
        res[0] = res1;
        res[1] = res2;
        return res;
    }

    public static int setLow0(int num, int count) {

        return (num >> count) << count;
    }

    // 把1个整数的某个位置的位，设置位0
    public int setPos0(int num, int pos) {

        int b = 1 << (pos - 1);
        return num & ~b;
    }

    // 把1个整数的某个位置的位，设置位1
    public int setPos1(int num, int pos) {

        int b = 1 << (pos - 1);
        return num | b;
    }

    public int popCount(int n) {

        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }

    public static void main(String[] args) {

        FindClosedNumbers findClosedNumbers = new FindClosedNumbers();
        findClosedNumbers.findClosedNumbers(1837591841);
    }
}
