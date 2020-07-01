package com.husd.leetcode.entry;

/**
 * 树的表示方法
 *
 * @author hushengdong
 * @create 2019-10-30 16:35:00
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
