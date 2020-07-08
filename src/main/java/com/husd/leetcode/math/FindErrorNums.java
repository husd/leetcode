package com.husd.leetcode.math;

/**
 * 645. 错误的集合
 * <p>
 * <p>
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 注意:
 * <p>
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 * 通过次数16,294提交次数38,289
 *
 * @author hushengdong
 */
public class FindErrorNums {

    //似曾相识 如果nums只是单纯的少了1个数字，很快通过异或就能找出来
    //关键是有2个数字重复了

    //这题无论是暴力解法 或者map 或者 arr来代替map 都是一个思想 ，效率也不低

    //看异或 假设重复的数字是x 缺的是y
    //
    public int[] findErrorNums(int[] nums) {

        int xor = 0, xor0 = 0, xor1 = 0;
        //nums自身先xor
        for (int n : nums)
            xor ^= n;
        //再和1-n做xor 结果就是 diff = x ^ y
        //这个时候找到diff的最右边的一个1
        //然后遍历整个数组，继续做异或 ，但是遇到Y之后就跳过
        for (int i = 1; i <= nums.length; i++)
            xor ^= i;
        int rightmostbit = xor & ~(xor - 1);
        //根据 rightmost 不同将数组 nums 分为两部分。
        // 第一部分所有数字的 rightmost 为 1，
        // 第二部分所有数字的 rightmost 为 0。
        // 那么 x 和 y 会被分配到不同的部分。
        // 此时问题就简化为最开始的简单问题。
        for (int n : nums) {
            if ((n & rightmostbit) != 0)
                xor1 ^= n;
            else
                xor0 ^= n;
        }
        for (int i = 1; i <= nums.length; i++) {
            if ((i & rightmostbit) != 0)
                xor1 ^= i;
            else
                xor0 ^= i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == xor0)
                return new int[]{xor0, xor1};
        }
        return new int[]{xor1, xor0};
    }
}
