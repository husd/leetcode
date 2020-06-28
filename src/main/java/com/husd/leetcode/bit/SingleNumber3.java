package com.husd.leetcode.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class SingleNumber3 {

    //hashmap明显不是最优答案 而且使用了额外的空间
    public int singleNumber(int[] nums) {

        int seenOnce = 0, seenTwice = 0;
        //这是官方解题
        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }

    //hashmap
    public int singleNumber2(int[] nums) {

        int res = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : nums) {
            int c = m.getOrDefault(i, 0);
            c++;
            m.put(i, c);
        }
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return res;
    }
}
