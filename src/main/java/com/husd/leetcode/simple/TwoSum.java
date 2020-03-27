package com.husd.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @date 2020/3/27
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        //hash <num,index>
        Map<Integer, Integer> _map = new HashMap<Integer, Integer>(nums.length * 2);
        for (int i = 0; i < nums.length; i++) {
            Integer _target = _map.get(target - nums[i]);
            if (_target != null && _target != i) {
                return new int[]{i, _target};
            }
            _map.put(nums[i], i);
        }
        return null;
    }
}
