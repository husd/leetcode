package com.husd.leetcode.math;

/**
 * 1037. 有效的回旋镖
 * <p>
 * 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
 * <p>
 * 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,1],[2,3],[3,2]]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：[[1,1],[2,2],[3,3]]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * points.length == 3
 * points[i].length == 2
 * 0 <= points[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-boomerang
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class Boomerang {

    //判断3个点，不在同一条直线 这是核心问题 3个点不同很好判断
    //判断斜率即可 a/b = c/d  ad = bc
    //画一个图即可
    public boolean isBoomerang(int[][] points) {

        //去掉以下3行之后，就好使了
        //int[] a = points[0];
        // int[] b = points[1];
        //int[] c = points[2];
        return !((points[0][0] - points[1][0]) * (points[0][1] - points[2][1]) == (points[0][0] - points[2][0]) * (points[0][1] - points[1][1]));
    }
}
