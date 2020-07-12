package com.husd.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 *
 * 示例 1:
 *
 * 输入: nums = [5,6,5], target = 11
 * 输出: [[5,6]]
 * 示例 2:
 *
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 * 提示：
 *
 * nums.length <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pairs-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PairSums {

    public List<List<Integer>> pairSums(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums) {
            int diff = target - i;
            int c2 = map.getOrDefault(diff,0);
            if(c2 > 0) {
                map.put(diff,--c2);
                List<Integer> a = new ArrayList<>(2);
                a.add(i);
                a.add(diff);
                res.add(a);
            } else {
                int c = map.getOrDefault(i,0);
                map.put(i,++c);
            }
        }

        return res;
    }
}
