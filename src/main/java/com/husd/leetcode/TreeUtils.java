package com.husd.leetcode;

import com.husd.leetcode.entry.TreeNode;

/**
 * @author hushengdong
 */
public class TreeUtils {

    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    public static TreeNode mockTree() {

        TreeNode treeNode = mockTreeNode(3);
        treeNode.left = mockTreeNode(9);
        treeNode.right = mockTreeNode(20);
        treeNode.right.left = mockTreeNode(15);
        treeNode.right.right = mockTreeNode(7);
        return treeNode;
    }

    public static TreeNode mockTreeNode(int n) {

        return new TreeNode(n);
    }
}
