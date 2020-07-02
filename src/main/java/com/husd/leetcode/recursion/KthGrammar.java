package com.husd.leetcode.recursion;

/**
 * 779. 第K个语法符号
 * <p>
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * <p>
 * <p>
 * 例子:
 * <p>
 * 输入: N = 1, K = 1
 * 输出: 0
 * <p>
 * 输入: N = 2, K = 1
 * 输出: 0
 * <p>
 * 输入: N = 2, K = 2
 * 输出: 1
 * <p>
 * 输入: N = 4, K = 5
 * 输出: 1
 * <p>
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 * <p>
 * 注意：
 * <p>
 * N 的范围 [1, 30].
 * K 的范围 [1, 2^(N-1)].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-symbol-in-grammar
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class KthGrammar {

    //溢出了
    public int kthGrammar(int N, int K) {
        String[] res = new String[31];
        res[1] = "0";
        res[2] = "01";
        for (int i = 3; i <= N; i++) {
            StringBuilder sb = new StringBuilder(res[i - 1].length() * 2);
            for (char c : res[i - 1].toCharArray()) {
                if (c == '0') {
                    sb.append("01");
                } else {
                    sb.append("10");
                }
            }
            res[i] = sb.toString();
        }
        return res[N].charAt(K - 1) - 48;
    }

    //这题变成了1个找规律的题 看官方题解即可 没有学习的意义了
    public int kthGrammar1(int N, int K) {
        return Integer.bitCount(K - 1) % 2;
    }

    //K在奇数位时，与N-1, (K+1)/2 位置的值相同
    //K在偶数位时，与N-1, K/2 位置的值相反
    public int kthGrammar2(int N, int K) {

        if (N == 0) return 0;
        if ((K & 1) == 1) {
            return kthGrammar2(N - 1, (K + 1) / 2);
        } else {
            return Math.abs(kthGrammar2(N - 1, K / 2) - 1);
        }
    }

    public static void main(String[] args) {

        KthGrammar m = new KthGrammar();
        m.kthGrammar(3, 1);
    }

}
