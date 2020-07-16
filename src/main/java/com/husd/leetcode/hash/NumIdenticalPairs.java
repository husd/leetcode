package com.husd.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 nums 。
 * <p>
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * <p>
 * 返回好数对的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class NumIdenticalPairs {

    public int numIdenticalPairs(int[] nums) {

        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> a = m.getOrDefault(nums[i], new ArrayList());
            a.add(i);
            m.put(nums[i],a);
        }
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> a = m.get(nums[i]);
            if (a != null) {
                for (int j : a) {
                    if (i < j) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
