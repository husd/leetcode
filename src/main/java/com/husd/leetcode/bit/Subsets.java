package com.husd.leetcode.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * https://leetcode-cn.com/problems/power-set-lcci/
 * <p>
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets {

    //思路是什么？ 看官方解法吧
    //在它们的指数级解法中，要确保生成的结果 完整 且 无冗余，有三种常用的方法：
    //递归
    //
    //回溯
    //
    //基于二进制位掩码和对应位掩码之间的映射字典生成排列/组合/子集
    //
    //相比前两种方法，第三种方法将每种情况都简化为二进制数，易于实现和验证。
    //
    //此外，第三种方法具有最优的时间复杂度，可以生成按照字典顺序的输出结果。
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //递归 不过多解释
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums.length == 1) {
            List<Integer> t = new ArrayList<>(1);
            t.add(nums[0]);
            res.add(t);
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int[] temp = new int[nums.length - i - 1];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = nums[i + 1 + j];
            }
            List<Integer> t = new ArrayList<>(1);
            t.add(nums[i]);
            List<List<Integer>> otherList = subsets(temp);
            for (List<Integer> a : otherList) {
                a.add(nums[i]);
                res.add(a);
            }
        }
        return res;
    }

    List<List<Integer>> output = new ArrayList();
    int n, k;

    //回溯方法
    public List<List<Integer>> subsets2(int[] nums) {

        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }

    //回溯方法
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new ArrayList(curr));

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }


    //例如，位掩码 0..00（全 0）表示空子集，位掩码 1..11（全 1）表示输入数组 nums。
    //
    //因此要生成所有子集，只需要生成从 0..00 到 1..11 的所有 n 位掩码。
    //
    //乍看起来生成二进制数很简单，但如何处理左边填充 0 是一个问题。因为必须生成固定长度的位掩码：例如 001，而不是 1。因此可以使用一些位操作技巧：
    //
    //作者：LeetCode
    //链接：https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<List<Integer>> subsets3(int[] nums) {

        List<List<Integer>> output = new ArrayList();
        int n = nums.length;
        //生成1个整数，长度是nums.length+1
        int start = (int) Math.pow(2, n);
        int end = (int) Math.pow(2, n + 1);
        for (int i = start; i < end; ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }
}
