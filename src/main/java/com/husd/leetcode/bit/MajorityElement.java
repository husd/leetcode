package com.husd.leetcode.bit;

import java.util.Arrays;

/**
 * 169. 多数元素
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 通过次数179,779提交次数282,556
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {

    //思路4： 投票算法
    //candidate 一定经历了不是答案，到最终是答案的变化过程
    public int majorityElement(int[] nums) {

        //TODO 值得一看
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            //因为count在不断变化，所以他可以再次回到count == 0
            //真他妈巧
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    //排序
    public int majorityElement1(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //暴力方法 分治方法就先不管了

}
