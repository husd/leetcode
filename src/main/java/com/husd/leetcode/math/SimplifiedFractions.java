package com.husd.leetcode.math;

import java.util.LinkedList;
import java.util.List;

/**
 * 1447. 最简分数
 * <p>
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 * 示例 4：
 * <p>
 * 输入：n = 1
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simplified-fractions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class SimplifiedFractions {

    //垃圾题目 本质就是求最大公约数 非要费尽口舌，设计这么个简单题，滥竽充数

    //只适合初级题目
    public List<String> simplifiedFractions(int n) {

        List<String> res = new LinkedList<>();
        if (n == 1) return res;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (j == 1 || gcd(i, j) == 1) {
                    res.add(j + "/" + i);
                }
            }
        }
        return res;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {

        SimplifiedFractions m = new SimplifiedFractions();
        List<String> res = m.simplifiedFractions(3);
        System.out.println(res);
    }
}
