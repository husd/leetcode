package com.husd.leetcode.math;

/**
 * 598. 范围求和 II
 * <p>
 * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
 * <p>
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
 * <p>
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * m = 3, n = 3
 * operations = [[2,2],[3,3]]
 * 输出: 4
 * 解释:
 * 初始状态, M =
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * <p>
 * 执行完操作 [2,2] 后, M =
 * [[1, 1, 0],
 * [1, 1, 0],
 * [0, 0, 0]]
 * <p>
 * 执行完操作 [3,3] 后, M =
 * [[2, 2, 1],
 * [2, 2, 1],
 * [1, 1, 1]]
 * <p>
 * M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 * 注意:
 * <p>
 * m 和 n 的范围是 [1,40000]。
 * a 的范围是 [1,m]，b 的范围是 [1,n]。
 * 操作数目不超过 10000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-addition-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class MaxCount {

    //最简单的方法是创建一个 m * nm∗n 的二维数组 arrarr，
    // 对所有操作都逐一将范围内的元素加一，
    // 最后数一遍最大元素的数目。
    // 由于我们知道所有操作总是会影响到 (0,0)(0,0)，
    // 所以元素 arr[0][0]arr[0][0] 总是最大的。
    // 在所有操作执行完之后，我们数有多少个跟 arr[0][0]arr[0][0] 一样大的元素就是答案。
    // 很不幸，这个方法会超时
    public int maxCount(int m, int n, int[][] ops) {

        //map记录每个数的数量
        int[][] arr = new int[m][n];
        for (int[] op : ops) {
            for (int i = 0; i < op[0]; i++) {
                for (int j = 0; j < op[1]; j++) {
                    arr[i][j] += 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == arr[0][0])
                    count++;
            }
        }
        return count;

    }

    //重合部分的面积 等于 边长最小的乘积
    public int maxCount2(int m, int n, int[][] ops) {
        int i = 0, j = 0;
        int min_c = m, min_r = n;
        for (i = 0; i < ops.length; i++) {
            min_c = Math.min(ops[i][0], min_c);
            min_r = Math.min(ops[i][1], min_r);
        }
        return min_c * min_r;
    }
}
