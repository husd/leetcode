package com.husd.leetcode.math;

/**
 * 1017. 负二进制转换
 * <p>
 * 给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。
 * <p>
 * 除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出："110"
 * 解释：(-2) ^ 2 + (-2) ^ 1 = 2
 * 示例 2：
 * <p>
 * 输入：3
 * 输出："111"
 * 解释：(-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 * 示例 3：
 * <p>
 * 输入：4
 * 输出："100"
 * 解释：(-2) ^ 2 = 4
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= N <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-to-base-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class BaseNeg2 {

    public String baseNeg2(int N) {

        if (N == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int sign = N > 0 ? 1 : -1;
        N = Math.abs(N);
        while (N != 0) {
            int r = N % -2;
            sb.append(r == -1 ? 1 : r);
            N /= -2;
            if (r == -1) N ++;
        }
        return sign == -1 ? 0 + sb.reverse().toString() : sb.reverse().toString();
    }

    //这个是常规的整数转2进制数字
    public String base2(int N) {

        if (N == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int sign = N > 0 ? 1 : -1;
        N = Math.abs(N);
        while (N != 0) {
            sb.append(N % 2);
            N = N / 2;
        }
        return sign == -1 ? 0 + sb.reverse().toString() : sb.reverse().toString();
    }

    public static void main(String[] args) {

        BaseNeg2 m = new BaseNeg2();
        String s = m.baseNeg2(-6);
        System.out.println(s);
    }
}
