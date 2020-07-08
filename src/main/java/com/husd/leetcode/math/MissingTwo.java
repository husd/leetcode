package com.husd.leetcode.math;

/**
 * 面试题 17.19. 消失的两个数字
 * <p>
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * <p>
 * 以任意顺序返回这两个数字均可。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 * <p>
 * 输入: [2,3]
 * 输出: [1,4]
 * 提示：
 * <p>
 * nums.length <= 30000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-two-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class MissingTwo {

    // 从1到N数组nums中，缺失了2个元素。那么N = nums.size() + 2
    //    缺失2个数字的和sumOfTwo = sum(1..N) - sum(nums)
    //    记threshold = sumOfTwo/2。因为缺失的2个数字不相等，所以一个小于等于threshold,一个大于threshold。
    //    只对小于等于threshold的元素求和，得到第一个缺失的数字:
    //    sum(1..threshold) - sum(nums中, 小于等于threshold的元素)
    //    第二个缺失的数字: sumOfTwo - 第一个缺失的数字

    //通过异或，是不是能找到相同的思路
    public int[] missingTwo(int[] nums) {

        int n = nums.length + 2;
        int target = n * (n + 1) / 2;
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
        int sumOfTwo = target - sum;
        int threshold = sumOfTwo / 2;
        //只对小于threshold的求和
        int t1 = threshold * (threshold + 1) / 2;
        sum = 0;
        for (int a : nums) {
            sum = sum + (a <= threshold ? a : 0);
        }
        int a1 = t1 - sum;
        int a2 = sumOfTwo - a1;
        return new int[]{a1, a2};
    }

    public int missingOne(int[] nums) {

        int n = nums.length + 1;
        int target = n * (n + 1) / 2;
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
        return target - sum;
    }

    public static void main(String[] args) {

        MissingTwo m = new MissingTwo();
        int n = 100;
        int b = n * (n + 1) / 2;
        System.out.println(b);
    }
}
