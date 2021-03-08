package com.husd.leetcode.string;

/**
 * 两个字符串最大公共子串
 *
 * @author hushengdong
 */
public class MaxTwoStringSameSubstring {

    static int findLongest(String A, String B) {
        int m = A.length();
        int n = B.length();
        if (n == 0 || m == 0) {
            return 0;
        }
        int rs = 0;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    rs = Math.max(rs, dp[i][j]);//每次更新记录最大值
                } else { //不相等的情况
                    dp[i][j] = 0;
                }
            }
        }
        return rs;//返回的结果为rs
    }

    public static void main(String[] args) {
        String str1 = "BDCABA";
        String str2 = "ABCBDAB";
        int array = findLongest(str1, str2);
        System.out.println(array);
    }
}
