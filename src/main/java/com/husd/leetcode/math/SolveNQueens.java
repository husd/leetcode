package com.husd.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.12. 八皇后
 * <p>
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * <p>
 * 注意：本题相对原题做了扩展
 * <p>
 * 示例:
 * <p>
 * 输入：4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @date 2020/4/16
 */
public class SolveNQueens {

    public int total = 0;

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> target = new ArrayList<>();
        //声明一个数组，记录每一个皇后的位置
        int[] loc = new int[n];
        queen(n, loc, 0, target);
        return target;
    }

    boolean queen(int n, int[] loc, int row, List<List<String>> target) {
        if (n == row) {
            //说明遍历到了最后一行，是正确的解法
            total++;
            target.add(createResult(loc, n));
            return true;
        } else {
            for (int col = 0; col != n; col++) {
                loc[row] = col;
                if (isOk(loc, row)) {
                    queen(n, loc, row + 1, target);
                }
            }
            return false;
        }
    }

    public boolean isOk(int[] loc, int row) {

        for (int i = 0; i != row; i++) {
            if (loc[i] == loc[row] || row - loc[row] == i - loc[i] || row + loc[row] == i + loc[i]) {
                return false;
            }
        }
        return true;
    }


    public List<String> createResult(int[] loc, int n) {

        List<String> r1 = new ArrayList<>();
        for (int i = 0; i < loc.length; i++) {
            r1.add(getRow(loc[i], n));
        }
        return r1;
    }

    public String getRow(int i, int n) {

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < n) {
            sb.append(index++ == i ? "Q" : ".");
        }
        return sb.toString();
    }
}
