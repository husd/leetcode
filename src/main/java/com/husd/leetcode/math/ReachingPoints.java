package com.husd.leetcode.math;

/**
 * 780. 到达终点
 * <p>
 * <p>
 * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
 * <p>
 * 给定一个起点 (sx, sy) 和一个终点 (tx, ty)，如果通过一系列的转换可以从起点到达终点，则返回 True ，否则返回 False。
 * <p>
 * 示例:
 * 输入: sx = 1, sy = 1, tx = 3, ty = 5
 * 输出: True
 * 解释:
 * 可以通过以下一系列转换从起点转换到终点：
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 * <p>
 * 输入: sx = 1, sy = 1, tx = 2, ty = 2
 * 输出: False
 * <p>
 * 输入: sx = 1, sy = 1, tx = 1, ty = 1
 * 输出: True
 * <p>
 * 注意:
 * <p>
 * sx, sy, tx, ty 是范围在 [1, 10^9] 的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reaching-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class ReachingPoints {

    //穷举搜索【超出时间限制】
    public boolean reachingPoints1(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) return false;
        if (sx == tx && sy == ty) return true;
        return reachingPoints(sx+sy, sy, tx, ty) || reachingPoints(sx, sx+sy, tx, ty);
    }

    //回溯法 （取模变体）【通过】
    //TODO 值得一看  回溯法
    public boolean reachingPoints2(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) break;
            if (tx > ty) {
                if (ty > sy) tx %= ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }
        return (tx == sx && ty == sy);
    }

    boolean res = false;

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {

        // int[][] arr = new int[2][2];

        int a = sx;
        int b = sx + sy;

        int c = sx + sy;
        int d = sy;

        if (ok(a, b, c, d, tx, ty)) {
            res = true;
            return true;
        }

        while (!ok(a, b, c, d, tx, ty) && sx <= tx && sy <= ty) {

            res = reachingPoints(a, b, tx, ty) || reachingPoints(c, d, tx, ty);
            if (res) return true;
        }

        return false;
    }

    private boolean ok(int a, int b, int c, int d, int tx, int ty) {

        return (a == tx && b == ty) || (b == tx && a == ty) || (c == tx && d == ty) || (d == tx && c == ty);
    }

    public static void main(String[] args) {

        ReachingPoints m = new ReachingPoints();

        boolean ok = m.reachingPoints(3, 3, 12, 9);
        System.out.println(1);
    }
}
