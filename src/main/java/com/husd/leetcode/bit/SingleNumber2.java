package com.husd.leetcode.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 260. 只出现一次的数字 III
 * <p>
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 示例 :
 * <p>
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 * <p>
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class SingleNumber2 {

    //只出现1次，可以使用异或操作找出来 这里出现了2个数字 可以把2个数字的异或找出来
    //
    public int[] singleNumber(int[] nums) {

        int[] res = new int[2];
        int xorMask = 0;
        for(int i : nums) {
            xorMask ^= i;
        }

        //xorMask是最终结果x y的异或的结果，根据xorMask不能直接得到x y
        //但是可以根据这个值，从nums中找到这个值
        int diff = xorMask & (-xorMask);

        int x = 0;
        for (int num : nums) {
            //这里相当于把x y其中的1个值，给过滤掉了，这样问题就回到了
            //1个数组，里面只有1个值不一样的问题，就简单了
           if ((num & diff) != 0) {
               x ^= num;
            }
        }

        return new int[] {x,x^xorMask};
    }

    //hash
    public int[] singleNumber2(int[] nums) {

        int[] res = new int[2];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : nums) {
            int c = m.getOrDefault(i, 0);
            c++;
            m.put(i, c);
        }
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() == 1) {
                if (res[0] == 0) {
                    res[0] = entry.getKey();
                } else {
                    res[1] = entry.getKey();
                }
            }
        }
        return res;
    }
}
