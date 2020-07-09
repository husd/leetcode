package com.husd.leetcode.binary;

/**
 * 441. 排列硬币
 * <p>
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * <p>
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * <p>
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * <p>
 * 示例 1:
 * <p>
 * n = 5
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第三行不完整，所以返回2.
 * 示例 2:
 * <p>
 * n = 8
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第四行不完整，所以返回3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class ArrangeCoins {

    //宗旨用2分法来做
    //标准写法
    //TODO 重点看
    //2分法的标准写法 经典 值得入门学习
    //溢出问题不在本主题
    public int arrangeCoins(int n) {

        long low = 1, high = n;
        while (low <= high) {
            //2分法的标准写法
            long mid = low + (high - low) / 2;
            //高斯数学法计算和
            long sum = mid * (mid + 1) / 2;
            if (sum > n) {
                high = mid - 1;
            } else if (sum < n) {
                low = mid + 1;
            } else {
                return (int) mid;
            }
        }
        //如果不够，就直接返回low - 1
        return (int) (low - 1);
    }
}
