package com.husd.leetcode.simple;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @date 2020/4/1
 */
public class MaxProfit {

    //最低点买入股票
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int current = prices[i];
            if (current < min) {
                min = Math.min(min, current);
            } else {
                max = Math.max(max, current - min);
            }
        }
        return max;
    }

    //暴力求解
    public int maxProfit2(int[] prices) {

        int cash = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                cash = Math.max(cash, prices[j] - prices[i]);
            }
        }
        return cash;
    }

    // 动态规划
    // k 表示最多可以交易几次
    public int maxProfit3(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        int days = prices.length;
        int k = 1;
        int[][] dp = new int[days][2];

        for (int i = 0; i < days; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }
            //今天没持有股票 = 昨天没持有 或者 昨天持有今天卖掉了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //今天持有股票 = 昨天持有股票 或者 昨天没有股票今天买进
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[days - 1][0];
    }

    // 动态规划
    // k 表示最多可以交易几次
    // 3版本的优化版本
    public int maxProfit4(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int dp_i_k_0 = 0;
        int dp_i_k_1 = -prices[0];
        for (int i = 0; i < n; i++) {
            //dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp_i_k_0 = Math.max(dp_i_k_0, dp_i_k_1 + prices[i]);
            //dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp_i_k_1 = Math.max(dp_i_k_1, -prices[i]);
        }
        return dp_i_k_0;
    }
}
