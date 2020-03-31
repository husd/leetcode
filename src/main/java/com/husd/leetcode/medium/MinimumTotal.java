package com.husd.leetcode.medium;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @date 2020/3/31
 */
public class MinimumTotal {


    //    作者：ggb2312
//    链接：https://leetcode-cn.com/problems/triangle/solution/javadong-tai-gui-hua-si-lu-yi-ji-dai-ma-shi-xian-b/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//    状态定义：dp[i][j]表示包含第i行第j列元素的最小路径和
//            状态分析
//    初始化：
//    dp[0][0]=triangle[0][0]
//    常规：
//    triangle[i][j]一定会经过triangle[i-1][j]或者triangle[i-1][j-1],
//    所以状态dp[i][j]一定等于dp[i-1][j]或者dp[i-1][j-1]的最小值+triangle[i][j]
//    特殊：
//    triangle[i][0]没有左上角 只能从triangle[i-1][j]经过
//    triangle[i][row[0].length]没有上面 只能从triangle[i-1][j-1]经过
//    转换方程：dp[i][j]=min(dp[i-1][j],dp[i-1][j-1])+triangle[i][j]


    public int minimumTotal(List<List<Integer>> triangle) {

        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int row = triangle.size();
        int column = triangle.get(row - 1).size();

        int[][] dp = new int[row][column];
        dp[0][0] = triangle.get(0).get(0);
        int target = Integer.MAX_VALUE;

        //从第2行开始推导，因为第1行就1个数字，已经确定了
        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                int current = triangle.get(i).get(j);
                if (j == 0) {
                    //最左边
                    dp[i][j] = dp[i - 1][0] + current;
                } else if (j == i) {
                    //最右边
                    dp[i][j] = dp[i - 1][j - 1] + current;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + current;
                }
            }
        }
        for (int i = 0; i < dp[row - 1].length; i++) {
            target = Math.min(target, dp[row - 1][i]);
        }
        return target;
    }

}
