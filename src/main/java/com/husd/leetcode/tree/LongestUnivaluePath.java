package com.husd.leetcode.tree;

import com.husd.leetcode.entry.TreeNode;

/**
 * 687. 最长同值路径
 * <p>
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 输出:
 * <p>
 * 2
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * 输出:
 * <p>
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class LongestUnivaluePath {

    int res;

    public int longestUnivaluePath(TreeNode root) {

        res = 0;
        longest(root);
        return res;
    }

    //递归做
    public int longest(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftMax = longest(root.left);
        int rightMax = longest(root.right);
        int c = root.val;
        int leftM = 0, rightM = 0;
        if (root.left != null && root.left.val == c) {
            leftM += 1 + leftMax;
        }
        if (root.right != null && root.right.val == c) {
            rightM += 1 + rightMax;
        }
        //这个是答案
        res = Math.max(res, leftM + rightM);
        //这个是递归子树的结果
        return Math.max(leftM, rightM);
    }


}
