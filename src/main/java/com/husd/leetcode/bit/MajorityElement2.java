package com.husd.leetcode.bit;

/**
 * 面试题 17.10. 主要元素
 * <p>
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 * <p>
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class MajorityElement2 {

    public int majorityElement(int[] nums) {

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
        int c = 0;
        for (int num : nums) {
            if (num == candidate) c++;
        }
        return c > (nums.length >> 1) ? candidate : -1;
    }

    public static void main(String[] args) {

        MajorityElement2 m = new MajorityElement2();
        int[] a = {3, 2};
        int c = m.majorityElement(a);
        System.out.println(c);
    }
}
