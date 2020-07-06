package com.husd.leetcode.math;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * <p>
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class HappyNum {

    public boolean isHappy(int n) {

        Set<Integer> repeat = new HashSet<>();
        int sum = n;
        while (sum != 1) {

            n = sum;
            sum = 0;
            while (n != 0) {
                int b = n % 10;
                sum = sum + b * b;
                n = n / 10;
            }
            if(sum != 1) {
                if(repeat.contains(sum)) {
                    return false;
                } else {
                    repeat.add(sum);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        HappyNum m = new HappyNum();
        boolean a = m.isHappy(19);
        System.out.println(a);
    }
}
