package com.husd.leetcode.bit;

/**
 * 1131. 绝对值表达式的最大值
 * <p>
 * 给你两个长度相等的整数数组，返回下面表达式的最大值：
 * <p>
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 * <p>
 * 其中下标 i，j 满足 0 <= i, j < arr1.length。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
 * 输出：13
 * 示例 2：
 * <p>
 * 输入：arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 * 输出：20
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= arr1.length == arr2.length <= 40000
 * -10^6 <= arr1[i], arr2[i] <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-of-absolute-value-expression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class MaxAbsValExpr {

    //数学办法处理
    //TODO 思考下原理
    public int maxAbsValExpr(int[] arr1, int[] arr2) {

        int maxA = Integer.MIN_VALUE, minA = Integer.MAX_VALUE;
        int maxB = Integer.MIN_VALUE, minB = Integer.MAX_VALUE;
        int maxC = Integer.MIN_VALUE, minC = Integer.MAX_VALUE;
        int maxD = Integer.MIN_VALUE, minD = Integer.MAX_VALUE;
        int x, y;
        int a, b, c, d;
        for (int i = 0; i < arr1.length; i++) {
            x = arr1[i];
            y = arr2[i];
            a = x + y + i;
            b = x + y - i;
            c = x - y + i;
            d = x - y - i;
            maxA = Math.max(maxA, a);
            minA = Math.min(minA, a);

            maxB = Math.max(maxB, b);
            minB = Math.min(minB, b);

            maxC = Math.max(maxC, c);
            minC = Math.min(minC, c);

            maxD = Math.max(maxD, d);
            minD = Math.min(minD, d);
        }
        a = maxA - minA;
        b = maxB - minB;
        c = maxC - minC;
        d = maxD - minD;

        return Math.max(Math.max(a, b), Math.max(c, d));
    }
}
