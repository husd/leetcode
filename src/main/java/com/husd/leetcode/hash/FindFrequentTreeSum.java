package com.husd.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 *  
 *
 * 示例 1：
 * 输入:
 *
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例 2：
 * 输入：
 *
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 *
 *  
 *
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindFrequentTreeSum {

    Map<Integer,Integer> m = new HashMap<>();
    int max_sum = Integer.MIN_VALUE;
    int max_c = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {

        dfs(root);
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : m.entrySet()) {

            int sum = entry.getKey();
            int count = entry.getValue();
            if(count == max_c) {
                res.add(sum);
            }
        }
        int [] arr =  new int[res.size()];
        for(int i=0;i<res.size();i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    int dfs(TreeNode root) {

        if(root == null) return 0;
        int sum = root.val + dfs(root.left) + dfs(root.right);
        int c = m.getOrDefault(sum,0);
        c++;
        m.put(sum,c);
        max_sum = Math.max(max_sum,sum);
        max_c = Math.max(max_c,c);
        return sum;
    }
}
