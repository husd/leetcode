package com.husd.leetcode.medium;

/**
 * 233. 数字 1 的个数
 * <p>
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * <p>
 * 示例:
 * <p>
 * 输入: 13
 * 输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @date 2020/4/16
 */
public class CountDigitOne {

    //方法一 暴力 【超时】
    //在方法一中，我们手动计算了每个数中 \text{'1'}’1’ 的个数，但这种计算是非常慢。因此，我们需要找到 \text{'1'}’1’ 在这些数中出现的规律。然后我们就能利用这个规律来形成数学公式解决问题了。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/number-of-digit-one/solution/shu-zi-1-de-ge-shu-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int count(int n) {

        int countr = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            countr += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }
        return countr;
    }
}
