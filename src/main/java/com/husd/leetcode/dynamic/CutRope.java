package com.husd.leetcode.dynamic;

/**
 * 给你一根长度为n的绳子，请把绳子剪成m段 (m和n都是整数，n>1并且m>1)
 * 每段绳子的长度记为k[0],k[1],…,k[m].
 * 请问k[0]k[1]…*k[m]可能的最大乘积是多少？
 * <p>
 * 例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
 * 看完题目，我们按照上面提到的“动态规划五部”解决问题
 * 1、判题题意是否为找出一个问题的最优解
 * 看到字眼是“可能的最大乘积是多少”，判断是求最优解问题，可以用动态规划解决；
 * <p>
 * 2、从上往下分析问题，大问题可以分解为子问题，子问题中还有更小的子问题
 * 题目中举了个例子：当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18；我们可以从这里开始突破，把长度为8绳子的最大乘积分解为数个子问题，长度为8我们可以把它看成长度为1和7的绳子的和，或者长度 为2和6的绳子的和，或者长度为3和5的绳子的和and so on!
 * 到这里，相信大家已经看到一丝真理了吧？
 * <p>
 * 3. 从下往上分析问题 ，找出这些问题之间的关联（状态转移方程）
 * 在第二点时，我们已经从上到下分析问题了，现在我们要从下往上分析问题了。分析可知，
 * f(8) 的值就是f(1)*f(7),f(2)*f(6),f(3)*f(5),f(4)*f(4)它们之中的最小值，即f(8) = Max{f(1)*f(7),f(2)*f(6),f(3)*f(5),f(4)*f(4)}
 * 只要知道f(1)到f(7)的值就能求出f(8)；对于f(7)，只要知道f(1)到f(6)的值就能求出f(6)；对于f(6)，只要知道f(1)到f(5)的值就能求出f(6)；以些类推，我们只要知道前几个边界的值，就能一步步迭代出后续的结果!
 * 状态转移方程： f(n)=Max{f(n-i)*f(i)} i={1,2,3,…,n/2}
 * <p>
 * 4. 讨论底层的边界问题
 * 底层的边界问题说的就是最小的前几个数值的f(n)的值，本题中就是f(0)、f(1)、f(2)、f(3)的值
 * 对于f(0)，长度为0的绳子，没办法剪，没有意义
 * 对于f(1)，长度为1的绳子，没办法剪，设为1
 * 对于f(2)，长度为2的绳子，只有一种剪法，剪成两段长度为1的绳子，但剪后的乘积为1，比自身更小；如果不是求自身的值，要求乘积最大值的话就没必要剪。
 * 对于f(3)，长度为3的绳子，只有一种剪法，剪成两段长度为1和2的绳子，但剪后的乘积为2，比自身更小；如果不是求自身的值，要求乘积最大值的话也没必要剪。
 * ————————————————
 * 版权声明：本文为CSDN博主「食鱼酱」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_38278878/java/article/details/80037455
 *
 * @author hushengdong
 * @date 2020/3/31
 * @tag 动态规划
 */
public class CutRope {

    public int cut(int n) {


        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        //对于f(3)，长度为3的绳子，只有一种剪法，剪成两段长度为1和2的绳子，但剪后的乘积为2
        if (n == 3) {
            return 2;
        }

        int max = 0;
        //数组用于存储绳子乘积最大值
        int[] value = new int[n + 1];
        value[0] = 0;
        value[1] = 1;
        value[2] = 2;
        value[3] = 3;
        //从f(4)开始计算
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int val = value[j] * value[i - j];
                max = Math.max(max, val);
            }
            value[i] = max;
        }
        max = value[n];
        return max;
    }
}