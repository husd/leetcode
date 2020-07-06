package com.husd.leetcode.dynamic;

/**
 * 剑指 Offer 49. 丑数
 * <p>
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class NthUglyNumber {

    //动态规划
    //关键写出来状态变化表达式

    // 丑数肯定是由其它的丑数，乘以2 3 5得来的，由此可以根据dp[0] = 1
    //分别计算乘以 2 3 5 得到的值，然后取其中的小的值，以此相加
    //轮番由2 3 5 作为因子，计算较大的丑数

    //TODO 值得一看 状态变化方程式不容易想到
    public int nthUglyNumber(int n) {

        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int m1 = dp[a] * 2, m2 = dp[b] * 3, m3 = dp[c] * 5;
            dp[i] = Math.min(m1, Math.min(m2, m3));
            if (dp[i] == m1) a++;
            if (dp[i] == m2) b++;
            if (dp[i] == m3) c++;
        }
        return dp[n - 1];
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int a1 = 1, b1 = 1, c1 = 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int m1 = a1 * a, m2 = b1 * b, m3 = c1 * c;
            dp[i] = Math.min(m1, Math.min(m2, m3));
            if (dp[i] == m1) a1++;
            if (dp[i] == m2) b1++;
            if (dp[i] == m3) c1++;
        }
        return dp[n - 1];
    }

    //TODO 值得一看 想想为什么不对
    public int nthUglyNumber2(int n, int a, int b, int c) {
        int a1 = 1, b1 = 1, c1 = 1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n+19; i++) {
            int m1 = a1 * a, m2 = b1 * b, m3 = c1 * c;
            int min = Math.min(m1, Math.min(m2, m3));
            if (min == m1) a1++;
            if (min == m2) b1++;
            if (min == m3) c1++;
            res = min;
        }
        return res;
    }

    public static void main(String[] args) {

        NthUglyNumber m = new NthUglyNumber();
        //int n = m.nthUglyNumber(5, 2, 11, 13);
        int n = m.nthUglyNumber2(1000000000,2,217983653,336916467);

        System.out.println(n);
    }

}
