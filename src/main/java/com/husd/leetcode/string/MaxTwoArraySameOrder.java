package com.husd.leetcode.string;

/**
 * 两个字符串最大公共子序列
 *
 * @author hushengdong
 */
public class MaxTwoArraySameOrder {

    public static int maxTwoArraySameOrderMethod(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        /**
         *** 定义一个二维数组保存公共子序列长度
         ** dp*[*i*][*j*]表示字符串*1*从头开始长度是*i*，字符串*2*从头开始长度是*j*，
         * 这两个字符串的最长公共子序列的长度
         *** 设置数组行列比他们长度大一往二维数组中填写数字时，
         * 每个位置的数字跟他上方或者左方或者左上方数字有关系，
         * 这样处理边界数字时不用处理这种情况，方便接下来的循环
         **/
        int dp[][] = new int[m + 1][n + 1];
        /**
         *** 初始化第一行第一列
         ** dp*[*0,j*]表示啥？表示字符串*1*的长度是*0*，
         * 字符串*2*的长度是*j*，这两个字符串的最长公共子序列的长度是*0*，因为，字符串*1* 根本就没有嘛
         **/
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                /**
                 *** 如果当*c*[*i*][*j*]时，字符串*1*从头开始长度是*i*，字符串*2*从头开始长度是*j*时他们最后一个字符相同
                 *** 就同时把他们向前移动一位，找*c*[*i-1*][*j-1*]时长度最大的再加一
                 *** 表现在二维数组中就是*c*[*i*][*j*]左上方的点
                 **/
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);
                System.out.println("i:" + i + "j:" + j + " c1:" + c1 + " c2:" + c2 + " ");
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    /**
                     *** 如果当*c*[*i*][*j*]时，他们最后一个字符不相同
                     *** 要将*str1*往前移动一位的*c*[*i-1*][*j*]的*lcs*长度，
                     *   或者将*str2*往前移动一位的*c*[*i*][*j-1*]的*lcs*长度
                     *** 哪个长，将它赋给*c*[*i*][*j*]
                     *** 表现在二维数组中就是*c*[*i*][*j*]上方的点或者左方的点
                     **/
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "BDCABA";
        String str2 = "ABCBDAB";
        int array = maxTwoArraySameOrderMethod(str1, str2);
        System.out.println(array);
    }
}
