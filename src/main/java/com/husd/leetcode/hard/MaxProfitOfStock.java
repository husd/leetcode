package com.husd.leetcode.hard;

/**
 * 123. 买卖股票的最佳时机 III
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @date 2020/4/1
 */
public class MaxProfitOfStock {

    // 常规的动态规划版本，可以使用一个3维数组
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    //优化之前的版本，可以把for循环展开
    public int maxProfit2(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n][k + 1][2];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
        }
        return dp[n - 1][k][0];
    }

    //优化之前的版本，可以把for循环展开
    //同时发现数组很多值是固定的，可以不用数组，用单个变量进行替代
    public int maxProfit3(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        int dpi_2_0 = 0;
        int dpi_2_1 = Integer.MIN_VALUE;
        int dpi_1_0 = 0;
        int dpi_1_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dpi_2_0 = Math.max(dpi_2_0, dpi_2_1 + prices[i]);
            dpi_2_1 = Math.max(dpi_2_1, dpi_1_0 - prices[i]);
            dpi_1_0 = Math.max(dpi_1_0, dpi_1_1 + prices[i]);
            dpi_1_1 = Math.max(dpi_1_1, -prices[i]);
        }
        return dpi_2_0;
    }

    //终极版本
    public int maxProfit4(int[] prices) {

        int a = 0, b = Integer.MIN_VALUE;
        int c = 0, d = Integer.MIN_VALUE;
        for (int price : prices) {
            c = Math.max(c, d + price);
            d = Math.max(d, a - price);
            a = Math.max(a, b + price);
            b = Math.max(b, -price);
        }
        return c;
    }
}
