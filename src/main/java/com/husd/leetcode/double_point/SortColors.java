package com.husd.leetcode.double_point;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class SortColors {

    //可以参考MoveZeros的思路
    //肯定是双指针是最优解
    //

    //
    public void sortColors(int[] nums) {

        int len = nums.length;
        //最后1个0
        int lastZero = 0;
        //第1个2
        int firstTwo = len - 1;
        for (int i = 0; i <= firstTwo; i++) {
            i = i < 0 ? 0 : i;
            int c = nums[i];
            if (c == 0) {
                nums[lastZero++] = 0;
            } else if (c == 2) {
                nums[i] = nums[firstTwo];
                nums[firstTwo] = 2;
                firstTwo--;
                i--;
            }
        }
        for (int i = lastZero; i <= firstTwo; i++) {
            nums[i] = 1;
        }
    }

    public static void main(String[] args) {

        SortColors m = new SortColors();
        int[] arr = {2,0,2,1,1,0};
        m.sortColors(arr);
        System.out.println(arr);
    }
}
