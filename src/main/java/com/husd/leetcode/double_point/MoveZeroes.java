package com.husd.leetcode.double_point;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class MoveZeroes {

    //最优解，省略了最后一步
    //TODO 值得研究
    public void moveZeroes(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[cur];
                nums[cur] = temp;
                lastNonZeroFoundAt++;
            }
        }
    }

    //记录下第一个非0的下表，然后依次往前移动非0的数字
    public void moveZeroes2(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //最简单，最笨的方法
    //统计0的数量，然后把所有非0的数字，都移动到临时数组中
    public void moveZeroes1(int[] nums) {

        int n = nums.length;

        // Count the zeroes
        int numZeroes = 0;
        for (int i = 0; i < n; i++) {
            numZeroes = numZeroes + (nums[i] == 0 ? 1 : 0);
        }

        // Make all the non-zero elements retain their original order.
        int[] temp = new int[n - numZeroes];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp[j++] = nums[i];
            }
        }

        // Move all zeroes to the end
        int k = 0;
        while (k < j) {
            nums[k] = temp[k];
            k++;
        }

        // Combine the result
        for (int i = j; i < n; i++) {
            nums[i] = 0;
        }
    }
}
