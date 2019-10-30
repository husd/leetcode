package com.husd.leetcode;

import com.husd.leetcode.entry.TreeNode;

/**
 * 反转二叉树
 *
 * @author hushengdong
 * @create 2019-10-30 16:31:00
 */
public class ReverseTree {

    public void reverse(TreeNode root) {
        
        if (root == null) {
            return;
        }

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        reverse(root.left);
        reverse(root.right);
    }
}
